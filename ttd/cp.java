package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cp extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp);

        webView = findViewById(R.id.webviewcp);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/Connaught+Place,+New+Delhi,+Delhi+110001/@28.6289332,77.2065322,15z/data=!3m1!4b1!4m5!3m4!1s0x390cfd37b741d057:0xcdee88e47393c3f1!8m2!3d28.6304203!4d77.2177216");

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
