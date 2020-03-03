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
import android.widget.RadioGroup;
import android.widget.Toast;

public class admin extends AppCompatActivity {
Button b1;
EditText e1,e2;
CheckBox c1;
String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        e1=findViewById(R.id.edit1);
        e2=findViewById(R.id.edit2);
        c1=findViewById(R.id.show);
        b1=findViewById(R.id.login);
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
                s2=e2.getText().toString();
                if(!s1.contentEquals("admin")||!s2.contentEquals("12345")){
                    Toast.makeText(admin.this, "Invalid credentials. Try Again", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i=new Intent(admin.this,adminhome.class);
                    startActivity(i);
                }
            }
        });
    }
}
