package com.example.gzs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class second extends AppCompatActivity {
Button adm,tp,sp,stud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_second);
        adm=findViewById(R.id.admin);
        tp=findViewById(R.id.tpo);
        sp=findViewById(R.id.spc);
        stud=findViewById(R.id.stu);
        adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(second.this,admin.class);
                startActivity(i);
            }
        });
        tp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(second.this,Tpo.class);
                startActivity(i);
            }
        });
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(second.this,Spc.class);
            startActivity(i);
            }
        });
        stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(second.this,Student.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(second.this).setIcon(R.drawable.logo)
                .setMessage("Do You Want To Exit The App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                }).setNegativeButton("No",null).show();
    }
}
