package com.explem.smalllemonade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Home_Fragment_Code_I_Know extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__fragment__code__i__know);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url4");
        WebView home_fragment_I_konw_web = (WebView) findViewById(R.id.home_fragment_I_konw_web);
        home_fragment_I_konw_web.loadUrl(url);
        home_fragment_I_konw_web.getSettings().setJavaScriptEnabled(true);
    }
}
