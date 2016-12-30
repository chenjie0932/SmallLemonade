package com.explem.smalllemonade.community;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseActivity;
import com.explem.smalllemonade.community.fragment.CategoryFragment;

public class CategoryDetailActivity extends BaseActivity implements View.OnClickListener {

    public FrameLayout framelayout_community_category;
    public String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_category);

//        Intent intent = getIntent();
//        flag = intent.getStringExtra("flag");
        initView();
    }

    private void initView() {

        findViewById(R.id.tv_back).setOnClickListener(this);
        framelayout_community_category = (FrameLayout) findViewById(R.id.framelayout_community_category);
        setTitle();

        CategoryFragment categoryFragment = new CategoryFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.framelayout_community_category,categoryFragment,"first").commit();
    }

    private void setTitle() {
        TextView tv_community_ditail_title = (TextView) findViewById(R.id.tv_community_ditail_title);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_back){
            finish();
        }

    }
}
