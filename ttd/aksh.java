package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class aksh extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aksh);

        webView = findViewById(R.id.webviewak);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Akshardham/@28.6208789,77.28164,14.13z/data=!4m12!1m6!3m5!1s0x390ce8d1468f587f:0xfdc31dfc77853baf!2sakshardham+mandir!8m2!3d28.543642!4d77.4176358!3m4!1s0x390ce35b9975b1fb:0x69a09f265ef3b22a!8m2!3d28.612673!4d77.2772634");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
