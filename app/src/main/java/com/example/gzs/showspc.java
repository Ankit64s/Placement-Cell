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

public class showspc extends AppCompatActivity {
EditText e1;
String s1,s2,s3;
Button b1;
TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showspc);
        e1=findViewById(R.id.idspc);
        t1=findViewById(R.id.namesp);
        t2=findViewById(R.id.mobsp);
        b1=findViewById(R.id.fetspc);
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
        sb.append(Config.DATA_URL7+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(showspc.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(showspc.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response) {
        String name = "";
        String mobile = "";
        try {
            JSONObject jo = new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name = jo.getString(Config.KEY_NAME);
            mobile = jo.getString(Config.KEY_MOBILE);
        } catch (JSONException e) {

        }
        t1.setText(name);
        t2.setText(mobile);
    }
}
