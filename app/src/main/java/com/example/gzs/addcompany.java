package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class addcompany extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6;
String s1,s2,s3,s4,s5,s6;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcompany);
        e1=findViewById(R.id.cid);
        e2=findViewById(R.id.cname);
        e3=findViewById(R.id.cpackage);
        e4=findViewById(R.id.cdate);
        e5=findViewById(R.id.cven);
        e6=findViewById(R.id.cother);
        b1=findViewById(R.id.creg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                registers();
            }
        });
    }
    public void registers(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/compreg.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(addcompany.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(addcompany.this, "Not Registered", Toast.LENGTH_SHORT).show();
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
