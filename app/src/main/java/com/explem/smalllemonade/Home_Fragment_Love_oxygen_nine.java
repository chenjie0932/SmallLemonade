package com.explem.smalllemonade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import static com.explem.smalllemonade.R.id.nine_star;

/**
 * //恋爱氧气接受传值
 */
public class Home_Fragment_Love_oxygen_nine extends AppCompatActivity implements View.OnClickListener {
    private  int a=6;
    private CheckBox nine_starx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__fragment__love_oxygen_nine);
        WebView home_fragment_love_oxygen_nine_web = (WebView) findViewById(R.id.home_fragment_love_oxygen_nine_web);
        ImageView tuichu = (ImageView) findViewById(R.id.tuichu);
        //心型图片
        nine_starx = (CheckBox) findViewById(nine_star);
        Intent intent =getIntent();
        String url = intent.getStringExtra("url");
        String url2 = intent.getStringExtra("url2");
        home_fragment_love_oxygen_nine_web.loadUrl(url);
        home_fragment_love_oxygen_nine_web.loadUrl(url2);
         nine_starx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
             if(nine_starx.isChecked()){
                 a=a+1;
                 nine_starx.setText(a+"");
             }else {
                 a=a-1;
                 nine_starx.setText(a+"");

             }

         }
     });
        tuichu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tuichu:
                finish();
                break;
        }
    }
}
