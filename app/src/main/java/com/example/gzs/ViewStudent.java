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

public class ViewStudent extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2,b3;
    String s1,s2,s3,s4,s5,s6,s7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        e1=findViewById(R.id.selid);
        e2=findViewById(R.id.selename);
        e3=findViewById(R.id.selcomp1);
        e4=findViewById(R.id.selpack1);
        e5=findViewById(R.id.selcomp2);
        e6=findViewById(R.id.selpack2);
        b1=findViewById(R.id.selfetc);
        b2=findViewById(R.id.stup);
        b3=findViewById(R.id.stdel);
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
        sb.append(Config.DATA_URL5+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewStudent.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewStudent.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response){
        String name="";
        String course="";
        String branch="";
        String address="";
        String mobile="";
        try{
            JSONObject jo=new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name=jo.getString(Config.KEY_NAME);
            course=jo.getString(Config.KEY_COURSE);
            branch=jo.getString(Config.KEY_BRANCH);
            address=jo.getString(Config.KEY_ADDRESS);
            mobile=jo.getString(Config.KEY_MOBILE);
        } catch (JSONException e) {

        }
        e2.setText(name);
        e3.setText(course);
        e4.setText(branch);
        e5.setText(address);
        e6.setText(mobile);

    }

    public void update(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/update.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewStudent.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewStudent.this, "Not Updated", Toast.LENGTH_SHORT).show();
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
    public void delete(){
        RequestQueue rq= Volley.newRequestQueue(this);
        StringRequest r1=new StringRequest(Request.Method.POST,"https://realfictionstories.000webhostapp.com/studentapi/delete.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ViewStudent.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewStudent.this, "Not Deleted", Toast.LENGTH_SHORT).show();
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

