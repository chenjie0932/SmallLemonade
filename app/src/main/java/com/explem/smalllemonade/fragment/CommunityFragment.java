package com.explem.smalllemonade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.community.fragment.SubCommunityFragment_Category;
import com.explem.smalllemonade.community.fragment.SubCommunityFragment_Some;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.view.ShowingPage;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import static com.explem.smalllemonade.R.id.rg_community_header;


/**
 * Created by Pooh on 2016/12/27.
 */

public class CommunityFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, SpringView.OnFreshListener {

    public RadioGroup rg_community_header;
    public CommunityPagerAdapter communityPagerAdapter;
    public ViewPager vp_community_content;

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
//        SpringView sv_community_content = (SpringView) getActivity().findViewById(R.id.sv_community_content);

        //头部
        rg_community_header = (RadioGroup) getActivity().findViewById(R.id.rg_community_header);

        vp_community_content = (ViewPager) getActivity().findViewById(R.id.vp_community_content);
        //上拉刷新下拉加载的设置
//        sv_community_content.setHeader(new DefaultHeader(getActivity()));
//        sv_community_content.setListener(this);

        //对头部进行监听
        rg_community_header.setOnCheckedChangeListener(this);

        communityPagerAdapter = new CommunityPagerAdapter(getActivity().getSupportFragmentManager());
//
        vp_community_content.setAdapter(communityPagerAdapter);


    }
    //对头部进行监听
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 1; i < 4; i++) {
            RadioButton childAt = (RadioButton) rg_community_header.getChildAt(i);
            if (childAt.getId() == checkedId){
//                childAt.setTextColor(0xffff00);
                vp_community_content.setCurrentItem(i-1);
            }else{
//                childAt.setTextColor(0x000000);
            }
        }

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
            if (position == 0){
                SubCommunityFragment_Category subCommunityFragment_category = new SubCommunityFragment_Category();
                return subCommunityFragment_category;
            }else{
                SubCommunityFragment_Some subCommunityFragment_some = new SubCommunityFragment_Some();
                return  subCommunityFragment_some;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }





}
