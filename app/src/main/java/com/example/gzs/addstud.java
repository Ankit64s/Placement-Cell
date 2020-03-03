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

public class addstud extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstud);
        e1=findViewById(R.id.stroll);
        e2=findViewById(R.id.stname);
        e3=findViewById(R.id.stcourse);
        e4=findViewById(R.id.stbranch);
        e5=findViewById(R.id.staddrs);
        e6=findViewById(R.id.stmob);
        b1=findViewById(R.id.regstd);
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
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(addstud.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(addstud.this, "Not Registered", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError {
                HashMap<String, String> hm = new HashMap<>();
                hm.put("r",s1);
                hm.put("n",s2);
                hm.put("c",s3);
                hm.put("b",s4);
                hm.put("a",s5);
                hm.put("m",s6);
                return hm;
            }
        };
        rq.add(r1);
    }
}
