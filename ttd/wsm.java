package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class wsm extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wsm);

        webView = findViewById(R.id.webviewwsm);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/World+Square+Mall/@28.6796357,77.3797743,17z/data=!3m2!4b1!5s0x390cf07ed00d0b95:0x10f2abedef51c3a4!4m5!3m4!1s0x390cf07ed1e6c453:0xb90fc4aaafe866f!8m2!3d28.679631!4d77.381963");

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
