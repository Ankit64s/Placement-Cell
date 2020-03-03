package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class StuSelected extends AppCompatActivity {
    Button b1;
    EditText e1;
    TextView t1,t2,t3,t4,t5;
    String s1,s2,s3,s4,s5,s6,s7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_selected);
        e1=findViewById(R.id.selid);
        t1=findViewById(R.id.selename);
        t2=findViewById(R.id.selcomp1);
        t3=findViewById(R.id.selpack1);
        t4=findViewById(R.id.selcomp2);
        t5=findViewById(R.id.selpack2);
        b1=findViewById(R.id.selfetc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                getData();
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
                Toast.makeText(StuSelected.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(StuSelected.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
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
        t1.setText(name);
        t2.setText(company1);
        t3.setText(package1);
        t4.setText(company2);
        t5.setText(package2);

    }
}
