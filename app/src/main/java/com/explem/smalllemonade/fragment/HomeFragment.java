package com.explem.smalllemonade.fragment;

import android.view.View;
import android.widget.TextView;

import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.sql.Dao;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.view.ShowingPage;

/**
 * Created by Pooh on 2016/12/27.
 */

public class HomeFragment extends BaseFragment{
    public static String path="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850";
    public static Dao dao;
    public static String data;
    @Override
    protected void onload() {
        //设置布局
        HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        TextView tv=new TextView(getActivity());
        tv.setText("主页....");
        //请求数据
        getData();
        return tv;
    }
    //请求数据的方法
    public void getData(){
        new BaseDate(getActivity()) {


            @Override
            protected void setResultError(ShowingPage.StateType stateLoadError) {

            }

            @Override
            public void setResultData(String data) {

            }
        }.getDate(path,"&page=1",1,BaseDate.NOMALTIME);
    }
}
