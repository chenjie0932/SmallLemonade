package com.explem.smalllemonade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.view.ShowingPage;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

/**
 * Created by Pooh on 2016/12/27.
 */

public class CommunityFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, SpringView.OnFreshListener {
    @Override
    protected void onload() {
        //设置布局
        CommunityFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.fragment_community);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //上拉刷新下拉加载
        SpringView sv_community_content = (SpringView) getActivity().findViewById(R.id.sv_community_content);
        //展示列表内容
        ViewPager vp_community_content = (ViewPager) getActivity().findViewById(R.id.vp_community_content);
        //头部
        RadioGroup rg_community_header = (RadioGroup) getActivity().findViewById(R.id.rg_community_header);

        //上拉刷新下拉加载的设置
        sv_community_content.setHeader(new DefaultHeader(getActivity()));
        sv_community_content.setListener(this);


        rg_community_header.setOnCheckedChangeListener(this);

//        CommunityPagerAdapter communityPagerAdapter = new CommunityPagerAdapter(getActivity().getSupportFragmentManager());
//
//        vp_community_content.setAdapter(communityPagerAdapter);


    }
    //对头部进行监听
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }

    class CommunityPagerAdapter extends FragmentPagerAdapter{

        public CommunityPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }





}
