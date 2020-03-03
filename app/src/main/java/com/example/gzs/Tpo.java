package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

public class Tpo extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    CheckBox c1;
    TextView t1;
    String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        t1=findViewById(R.id.edit3);
        c1=findViewById(R.id.show);
        b1=findViewById(R.id.fetci);
        b2=findViewById(R.id.login);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
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
                s4=e2.getText().toString();
                if(s4.contentEquals(s3)){
                    Intent i=new Intent(Tpo.this,tpohome.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Tpo.this, "invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void getData(){
        s1=e1.getText().toString();
        RequestQueue rq= Volley.newRequestQueue(this);
        StringBuilder sb=new StringBuilder();
        sb.append(Config.DATA_URL1+s1);
        rq.add(new StringRequest(sb.toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Tpo.this, "Data FETCHED", Toast.LENGTH_SHORT).show();
                ShowJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Tpo.this, "Data Not Fetched", Toast.LENGTH_SHORT).show();
            }
        }));
    }
    public void ShowJson(String response){
        String name="";
        String password="";
        try{
            JSONObject jo=new JSONObject(response).getJSONArray(Config.KEY_RESULT).getJSONObject(0);
            name=jo.getString(Config.KEY_NAME);
            password=jo.getString(Config.KEY_PASSWORD);
        } catch (JSONException e) {

        }
        t1.setText(name);
        s3=password;

    }
}
