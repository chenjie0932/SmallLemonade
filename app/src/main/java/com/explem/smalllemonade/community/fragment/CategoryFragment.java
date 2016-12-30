package com.explem.smalllemonade.community.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.community.bean.CommunityContent;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.utils.Pathes;
import com.explem.smalllemonade.view.ShowingPage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class CategoryFragment extends BaseFragment {
    //请求到的数据
//    public List<CommunityContent.Data> dataList;
    public View view;
    public List<CommunityContent> allList = new ArrayList<>();

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onload() {
        MyBaseData myBaseData = new MyBaseData(getActivity());

        myBaseData.getDate(Pathes.CommonTopPath, Pathes.FirstTopArgs, 0, 0);

//        myBaseData.getDate(Pathes.CommonContentPath, Pathes.FirstContentArgs, 0, 0);
    }

    @Override
    protected View createSuccessView() {
        view = CommonUtils.inflate(R.layout.category_fragment_layout);

        ListView listview_category_fragment = (ListView) view.findViewById(R.id.listview_category_fragment);
        RecyclerView recyclerview_category_fragment = (RecyclerView) view.findViewById(R.id.recyclerview_category_fragment);

        Log.i("title111",allList.size()+"!!!!!!!!!!!!!!!!!!!!!!");
//        listview_category_fragment.setAdapter(new MyAdapter(getActivity(), dataList));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

//    public getData(String path,String args,int){
//
//    }

    //请求数据
    class MyBaseData extends BaseDate {

        public MyBaseData(Context context) {
            super(context);
        }

        @Override
        protected void setResultError(ShowingPage.StateType stateLoadError) {

        }

        @Override
        public CommunityContent setResultData(String data) {
//请求数据
            Gson gson = new Gson();
            CommunityContent communityContent = gson.fromJson(data, CommunityContent.class);


            allList.add(communityContent);
//            dataList = communityContent.getData();

            CategoryFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            return communityContent;
        }
    }


}
