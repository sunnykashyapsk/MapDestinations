package com.example.lenovo.ttd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cityforest extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cityforest);

        webView = findViewById(R.id.webviewcf);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/maps/place/City+Forest+Ghaziabad,+Raj+Nagar+Ext+Rd,+Ghaziabad,+Uttar+Pradesh+201003/@28.6969822,77.3901384,15z/data=!3m1!4b1!4m5!3m4!1s0x390cf08d45ee8daf:0xa2416cfd0575e022!8m2!3d28.6969641!4d77.3988932");

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
