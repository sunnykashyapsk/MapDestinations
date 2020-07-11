package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webviewcl);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Boys+Hostel,+Jaypee+University+Anoopshahr/@28.3391798,78.241899,15z/data=!4m12!1m6!3m5!1s0x390b48703a52c565:0xcdef6d1cc35b0542!2sYourStyler!8m2!3d28.3244546!4d78.2248291!3m4!1s0x0:0xf45a5d13eefdd244!8m2!3d28.3411952!4d78.2667893");

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
