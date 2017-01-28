package com.example.benji.ledou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        WebSettings wv_setttig = webview.getSettings();
        wv_setttig.setJavaScriptEnabled(true);
        wv_setttig.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // web内容强制满屏


        String url = "http://www.taobao.com";
        webview.loadUrl(url);


          /*禁止跳转到其他页面*/
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;

            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
