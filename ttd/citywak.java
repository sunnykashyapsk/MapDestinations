package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class citywak extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citywak);

        webView = findViewById(R.id.webviewck);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Select+CITYWALK/@28.5286199,77.217406,17z/data=!3m2!4b1!5s0x390ce18b1f46ef05:0xd23b80b99ddb1f67!4m5!3m4!1s0x390ce18ac60e4a61:0x81c366c7998e72a3!8m2!3d28.5286152!4d77.2195947");

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
