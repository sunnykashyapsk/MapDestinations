package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Redfort extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redfort);
        webView = findViewById(R.id.webviewrf);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Red+Fort/@28.6561639,77.2388316,17z/data=!3m1!4b1!4m5!3m4!1s0x390cfce26ec085ef:0x441e32f4fa5002fb!8m2!3d28.6561592!4d77.2410203");

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
