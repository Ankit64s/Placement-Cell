package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tpohome extends AppCompatActivity {
Button comp,stude,selstu,spc;
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpohome);
        comp=findViewById(R.id.addco);
        stude=findViewById(R.id.addstu);
        selstu=findViewById(R.id.addsel);
        spc=findViewById(R.id.addspc);
        b1=findViewById(R.id.vicom);
        b2=findViewById(R.id.vistu);
        b3=findViewById(R.id.visel);
        b4=findViewById(R.id.vispc);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,addcompany.class);
                startActivity(i);
            }
        });
        stude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(tpohome.this,addstud.class);
            startActivity(i);
            }
        });
        selstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(tpohome.this,addselected.class);
            startActivity(i);
            }
        });
        spc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,addspc.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,ViewCompany.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,ViewStudent.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,ViewSelstu.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tpohome.this,ViewSpc.class);
                startActivity(i);
            }
        });
    }
}
