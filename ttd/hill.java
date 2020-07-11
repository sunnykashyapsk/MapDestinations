package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class hill extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hill);

        webView = findViewById(R.id.webviewhill);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Dandachali/@30.197082,77.9608281,10.33z/data=!4m8!1m2!2m1!1shill+stations!3m4!1s0x0:0x4be66635d17adfa2!8m2!3d30.3133944!4d78.4155178");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
