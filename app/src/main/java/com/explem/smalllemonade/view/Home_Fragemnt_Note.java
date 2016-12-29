package com.explem.smalllemonade.view;
/**
 * @auto XuJiaJian
 * 主页
 * 信息界面
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.fragment.Home_Fragment_Reply;
import com.explem.smalllemonade.fragment.Home_Fragment_Talk;

import java.util.ArrayList;

public class Home_Fragemnt_Note extends AppCompatActivity implements View.OnClickListener {

    private ImageView home_fragment__note_back;
    private ViewPager home_fragment_vp;
    private RadioGroup activity_home__fragemnt__rg;
    private CheckBox home_fragment__note_che, home_fragment__note_che2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__fragemnt__note);
        InitView();

    }

    private void InitView() {
        //退出图片
        home_fragment__note_back = (ImageView) findViewById(R.id.home_fragment__note_back);
        activity_home__fragemnt__rg = (RadioGroup) findViewById(R.id.activity_home__fragemnt__rg);
        home_fragment_vp = (ViewPager) findViewById(R.id.home_fragment_vp);
        //cheBox
        home_fragment__note_che = (CheckBox) findViewById(R.id.home_fragment__note_che);
        home_fragment__note_che2 = (CheckBox) findViewById(R.id.home_fragment__note_che2);
        getFragment();
        getColor();
        home_fragment_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentlist.get(position);

            }

            @Override
            public int getCount() {
                return fragmentlist.size();
            }
        });
        home_fragment__note_back.setOnClickListener(this);
        home_fragment_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < fragmentlist.size(); i++) {
                    RadioButton childAt = (RadioButton) activity_home__fragemnt__rg.getChildAt(i);
                    if (position == i) {
                        childAt.setTextColor(Color.parseColor("#FFA042"));
                        home_fragment__note_che.setChecked(false);
                        home_fragment__note_che2.setChecked(true);
                    } else {
                        childAt.setTextColor(Color.parseColor("#3C3C3C"));
                        home_fragment__note_che.setChecked(true);
                        home_fragment__note_che2.setChecked(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //RadioGroup监听事件
        activity_home__fragemnt__rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedid) {
                for (int i = 0; i < fragmentlist.size(); i++) {
                    if (activity_home__fragemnt__rg.getChildAt(i).getId() == checkedid) {
                        home_fragment_vp.setCurrentItem(i);
                    }
                }
            }
        });
    }

    //添加颜色集合
    ArrayList<Integer> colorlist = new ArrayList<>();

    private void getColor() {
        colorlist.add(R.color.popCoffeeColor);
        colorlist.add(R.color.X_Black);
    }

    //添加Fragment集合
    ArrayList<Fragment> fragmentlist = new ArrayList<>();

    private void getFragment() {
        Home_Fragment_Talk f1 = new Home_Fragment_Talk();
        Home_Fragment_Reply f2 = new Home_Fragment_Reply();
        fragmentlist.add(f1);
        fragmentlist.add(f2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_fragment__note_back:
                finish();
                break;
        }

    }


}
