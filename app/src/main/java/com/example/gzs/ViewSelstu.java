package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class ViewSelstu extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7;
Button b1,b2,b3;
TextView t1,t2,t3,t4,t5,t6;
String s1,s2,s3,s4,s5,s6,s7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_selstu);
        e1=findViewById(R.id.selid);
        e2=findViewById(R.id.selename);
        e3=findViewById(R.id.selcomp1);
        e4=findViewById(R.id.selpack1);
        e5=findViewById(R.id.selcomp2);
        e6=findViewById(R.id.selpack2);
        e7=findViewById(R.id.selmobi);
        b1=findViewById(R.id.selfetc);
        b2=findViewById(R.id.selup);
        b3=findViewById(R.id.seldel);
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
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
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
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                delete();
            }
        });
    }
    public void getData(){
        s1=e1.getText().toString();
        RequestQueue rq= Volley.newRequestQueue(this);
        StringBuilder sb=new StringBuilder();
        sb.append(Config.DATA_URL3+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSelstu.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSelstu.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response){
        String name="";
        String company1="";
        String package1="";
        String company2="";
        String package2="";
        String mobile="";
        try{
            JSONObject jo=new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name=jo.getString(Config.KEY_NAME);
            company1=jo.getString(Config.KEY_COMPANY1);
            package1=jo.getString(Config.KEY_PACKAGE1);
            company2=jo.getString(Config.KEY_COMPANY2);
            package2=jo.getString(Config.KEY_PACKAGE2);
            mobile=jo.getString(Config.KEY_MOBILE);
        } catch (JSONException e) {

        }
        e2.setText(name);
        e3.setText(company1);
        e4.setText(package1);
        e5.setText(company2);
        e6.setText(package2);
        e7.setText(mobile);

    }
    public void update(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/selupdate.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSelstu.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSelstu.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("u",s1);
                hm.put("n",s2);
                hm.put("c",s3);
                hm.put("p",s4);
                hm.put("d",s5);
                hm.put("q",s6);
                hm.put("m",s7);
                return hm;
            }
        };
        rq.add(r1);
    }
    public void delete(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/seldelete.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewSelstu.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSelstu.this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("u",s1);
                hm.put("n",s2);
                hm.put("c",s3);
                hm.put("p",s4);
                hm.put("d",s5);
                hm.put("q",s6);
                hm.put("m",s7);
                return hm;
            }
        };
        rq.add(r1);

    }
}
