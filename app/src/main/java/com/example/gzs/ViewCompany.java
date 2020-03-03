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

public class ViewCompany extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6;
Button b1,b2,b3;
String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_company);
        e1=findViewById(R.id.comid);
        e2=findViewById(R.id.comname);
        e3=findViewById(R.id.compack);
        e4=findViewById(R.id.comdate);
        e5=findViewById(R.id.comven);
        e6=findViewById(R.id.comoth);
        b1=findViewById(R.id.comfetc);
        b2=findViewById(R.id.comup);
        b3=findViewById(R.id.comdel);
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
                delete();
            }
        });
    }
    public void getData(){
        s1=e1.getText().toString();
        RequestQueue rq= Volley.newRequestQueue(this);
        StringBuilder sb=new StringBuilder();
        sb.append(Config.DATA_URL4+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewCompany.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewCompany.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response){
        String name="";
        String package1="";
        String date="";
        String venue="";
        String other="";

        try{
            JSONObject jo=new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name=jo.getString(Config.KEY_NAME);
            package1=jo.getString(Config.KEY_PACKAGE);
            date=jo.getString(Config.KEY_DATE);
            venue=jo.getString(Config.KEY_VENUE);
            other=jo.getString(Config.KEY_OTHER);
        } catch (JSONException e) {

        }
        e2.setText(name);
        e3.setText(package1);
        e4.setText(date);
        e5.setText(venue);
        e6.setText(other);
    }
    public void update(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/comupdate.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewCompany.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewCompany.this, "Not Updated", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("i",s1);
                hm.put("n",s2);
                hm.put("p",s3);
                hm.put("d",s4);
                hm.put("v",s5);
                hm.put("o",s6);
                return hm;
            }
        };
        rq.add(r1);
    }
    public void delete(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/comdelete.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewCompany.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewCompany.this, "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("i",s1);
                hm.put("n",s2);
                hm.put("p",s3);
                hm.put("d",s4);
                hm.put("v",s5);
                hm.put("o",s6);
                return hm;
            }
        };
        rq.add(r1);
    }
}
