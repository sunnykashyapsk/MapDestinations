package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Buland extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buland);

        webView = findViewById(R.id.webviewbd);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Buland+Gate,+Dadupura,+Fatehpur+Sikri,+Uttar+Pradesh+283110/@27.0943039,77.6605956,17z/data=!3m1!4b1!4m5!3m4!1s0x397393fd1cd2b971:0xc19e95eb4b83a1e3!8m2!3d27.0942991!4d77.6627843");
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
