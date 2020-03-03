package com.example.gzs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class apply extends AppCompatActivity {
String url;
WebView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        v1=findViewById(R.id.web1);
        url="https://placementapply.blogspot.com/2019/12/apply-for-drives.html";
        v1.getSettings().setJavaScriptEnabled(true);
        v1.loadUrl(url);
    }
}
