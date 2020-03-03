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

public class addtpo extends AppCompatActivity {
EditText e1,e2,e3,e4;
String s1,s2,s3,s4;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtpo);
        e1=findViewById(R.id.tpid);
        e2=findViewById(R.id.tpname);
        e3=findViewById(R.id.tppwd);
        e4=findViewById(R.id.tpmob);
        b1=findViewById(R.id.regtpo);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                if(s1!=null && s2!=null && s3!=null && s4!=null){
                    registers();
                }
                else {
                    Toast.makeText(addtpo.this, "Not set to string", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void registers(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/tporeg.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(addtpo.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(addtpo.this, "Not Registered", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String,String> getParams() throws AuthFailureError{
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
