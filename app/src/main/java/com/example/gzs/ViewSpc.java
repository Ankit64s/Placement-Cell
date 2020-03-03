package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ViewSpc extends AppCompatActivity {
EditText e1,e2,e3,e4;
CheckBox c1;
Button b1,b2,b3;
String s1,s2,s3,s4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spc);
        e1=findViewById(R.id.idspc);
        e2=findViewById(R.id.namesp);
        e3=findViewById(R.id.pwdsp);
        e4=findViewById(R.id.mobsp);
        c1=findViewById(R.id.show);
        b1=findViewById(R.id.fetspc);
        b2=findViewById(R.id.spcup);
        b3=findViewById(R.id.spcdel);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    e3.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    e3.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                getData();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                update();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                delete();
            }
        });
    }
    public void getData(){
        s1=e1.getText().toString();
        RequestQueue rq= Volley.newRequestQueue(this);
        StringBuilder sb=new StringBuilder();
        sb.append(Config.DATA_URL6+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSpc.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSpc.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response){
        String name="";
        String mobile="";
        String password="";
        try{
            JSONObject jo=new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name=jo.getString(Config.KEY_NAME);
            password=jo.getString(Config.KEY_PASSWORD);
            mobile=jo.getString(Config.KEY_MOBILE);
        } catch (JSONException e) {

        }
        e2.setText(name);
        e3.setText(password);
        e4.setText(mobile);

    }

    public void update(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/spcupdate.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSpc.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSpc.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("i",s1);
                hm.put("n",s2);
                hm.put("p",s3);
                hm.put("m",s4);
                return hm;
            }
        };
        rq.add(r1);
    }
    public void delete(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/spcdelete.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSpc.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSpc.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("i",s1);
                hm.put("n",s2);
                hm.put("p",s3);
                hm.put("m",s4);
                return hm;
            }
        };
        rq.add(r1);

    }
}
