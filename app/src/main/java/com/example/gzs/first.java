package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class first extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportActionBar().hide();
        getWindow().setFlags(1024, 1024);
        /*new Handler().postDelayed(new Runnable() {
            public void run() {
                first.this.startActivity(new Intent(first.this, second.class));
                first.this.finish();
            }
        }, 3000);*/
    }
}
