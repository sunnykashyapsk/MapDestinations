package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bird extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird);

        webView = findViewById(R.id.webviewbird);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Okhla+Bird+Sanctury,+Sector+95,+Noida/@28.5834375,77.3129627,11.67z/data=!4m5!3m4!1s0x390ce46c621529e5:0x587c1e97c55e891c!8m2!3d28.5653312!4d77.3008506");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
