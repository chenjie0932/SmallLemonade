package com.explem.smalllemonade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;

public class UapdateNameAcitvity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_tvright;
    private TextView title_tvtitle, upn_tvdesc;
    private Intent intent;
    private int id;
    private AutoRelativeLayout upn_re;
    private RadioGroup upn_rg;
    private RecyclerView upn_rcl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uapdate_name_acitvity);
        //找控件
        initView();
        getIntentData();
    }

    //判断跳转的类型 显示不同的页面
    public void getIntentData() {
        intent = getIntent();
        id = intent.getIntExtra("id", 0);
        switch (id) {
            //昵称
            case 0:
                title_tvtitle.setText("修改昵称");
                title_tvright.setText("完成");
                upn_tvdesc.setVisibility(View.VISIBLE);
                upn_re.setVisibility(View.VISIBLE);
                break;
            //情感
            case 1:
                title_tvtitle.setText("情感状况");
                title_tvright.setText("完成");
                upn_rg.setVisibility(View.VISIBLE);

                break;
            //工作
            case 2:
                title_tvtitle.setText("选择职业");
                title_tvright.setText("取消");
                upn_rcl.setVisibility(View.VISIBLE);
                break;

        }
    }

    private void initView() {
        findViewById(R.id.title_imgback).setOnClickListener(this);
        title_tvtitle = (TextView) findViewById(R.id.title_tvtitle);
        title_tvright = (TextView) findViewById(R.id.title_tvright);
        title_tvtitle.setOnClickListener(this);
        upn_tvdesc = (TextView) findViewById(R.id.upn_tvdesc);
        upn_re = (AutoRelativeLayout) findViewById(R.id.upn_re);
        upn_rg = (RadioGroup) findViewById(R.id.upn_rg);
        upn_rcl = (RecyclerView) findViewById(R.id.upn_rcl);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //后退
            case R.id.title_imgback:
                finish();
                break;
            //点击完成或取消
            case R.id.title_tvright:
                String title = title_tvtitle.getText().toString().trim();
                if (title.equals("修改昵称")) {

                } else if (title.equals("情感状态")) {

                } else if (title.equals("选择职业")) {

                }
                break;

        }
    }
}
