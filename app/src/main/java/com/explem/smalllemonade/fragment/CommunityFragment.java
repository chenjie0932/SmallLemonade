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

/**
 * Created by Pooh on 2016/12/27.
 */

public class CommunityFragment extends BaseFragment{
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
        ViewPager vp_community_content = (ViewPager) getActivity().findViewById(R.id.vp_community_content);
        RadioGroup rg_community_header = (RadioGroup) getActivity().findViewById(R.id.rg_community_header);

//        CommunityPagerAdapter communityPagerAdapter = new CommunityPagerAdapter();
//
//        vp_community_content.setAdapter(communityPagerAdapter);


    }

//    class CommunityPagerAdapter extends FragmentPagerAdapter{
//
//        public CommunityPagerAdapter( fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//    }





}
