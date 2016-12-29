package com.explem.smalllemonade.community.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.community.adapter.SubCommunityFragmentAdapter;
import com.explem.smalllemonade.community.bean.CommunityContent;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.view.ShowingPage;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.xutils.common.util.LogUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class SubCommunityFragment_Some extends BaseFragment implements SpringView.OnFreshListener {

    public int type;
    public String path = "http://www.yulin520.com/a2a/forum/allTypeList";
    public String args = "sign=0A1CA7FA70FD4F4B1E141438594A4C10&pageSize=10&sort=2&ts=1482920553&page=1&forumType=0";
    public List<CommunityContent.Data> dataList;
    public View view;

    @Override
    protected void onload() {

        MyBaseData myBaseData = new MyBaseData(getActivity());
        myBaseData.getDate(path,args,0,0);


    }

    @Override
    protected View createSuccessView() {

        view = CommonUtils.inflate(R.layout.subcommunityfragment_all);
        ListView listview_subcommunityfragment = (ListView) view.findViewById(R.id.listview_subcommunityfragment);
        SpringView springview_subcommunityfragment = (SpringView) view.findViewById(R.id.springview_subcommunityfragment);
        springview_subcommunityfragment.setHeader(new DefaultHeader(getActivity()));
        springview_subcommunityfragment.setListener(this);

        listview_subcommunityfragment.setAdapter(new SubCommunityFragmentAdapter(getActivity(),dataList));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }

    public class MyBaseData extends BaseDate{

        public MyBaseData(Context context) {
            super(context);
        }
        @Override
        protected void setResultError(ShowingPage.StateType stateLoadError) {

        }
        @Override
        public void setResultData(String data) {
            Gson gson = new Gson();
            CommunityContent communityContent = gson.fromJson(data, CommunityContent.class);
            dataList = communityContent.getData();

            SubCommunityFragment_Some.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        }
    }


//    public Fragment setFragment(int type){
//
//        SubCommunityFragment_Some subCommunityFragment = new SubCommunityFragment_Some();
//        Bundle bundle = new Bundle();
//        bundle.putInt("type",type);
//        subCommunityFragment.setArguments(bundle);
//        return subCommunityFragment;
//    }
}
