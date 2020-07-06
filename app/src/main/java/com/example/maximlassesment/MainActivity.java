package com.example.maximlassesment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         final ProgressBar bar = findViewById(R.id.progressBar);

        WebView mWebView = findViewById(R.id.web_View);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

     Uri data = getIntent().getData();
     if(data != null)
     {

         Log.d("linkApp", "url : " +data.getScheme() + data.getSchemeSpecificPart());
         mWebView.loadUrl(data.getScheme() + ":" + data.getSchemeSpecificPart());
     }
     else
     {
         mWebView.loadUrl("https://www.google.com/");
     }

     mWebView.setWebViewClient(new WebViewClient() {
         @Override
         public void onPageFinished(WebView view, String url) {
             bar.setVisibility(View.GONE);
         }
     });





    }
}