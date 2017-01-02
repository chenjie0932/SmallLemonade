package com.explem.smalllemonade.community.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.community.adapter.MyAdapter;
import com.explem.smalllemonade.community.adapter.MyRecyclerView;
import com.explem.smalllemonade.community.bean.CommunityContent;
import com.explem.smalllemonade.fragment.HomeFragment;
import com.explem.smalllemonade.utils.BaseDate;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.utils.Pathes;
import com.explem.smalllemonade.view.ShowingPage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.content;
import static android.R.id.message;

/**
 * Created by Administrator on 2016/12/30 0030.
 */

public class CategoryFragment extends BaseFragment {
    //请求到的数据
//    public List<CommunityContent.Data> dataList;
    public View view;
    public List<CommunityContent> allList = new ArrayList<>();
    private static final int TOP = 100;
    private static final int CONTENT = 200;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            CommunityContent communityContent = (CommunityContent) msg.obj;
            switch (msg.what) {
                case TOP:
                    listview_category_fragment.setAdapter(new MyAdapter(getActivity(), communityContent.getData()));
                    break;

                case CONTENT:
                    Log.i("123321", "content");
                    recyclerview_category_fragment.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerview_category_fragment.setAdapter(new MyRecyclerView(getActivity(),communityContent.getData()));
                    break;
            }
        }
    };
    public ListView listview_category_fragment;
    public RecyclerView recyclerview_category_fragment;

    @Override
    protected void onload() {

        CategoryFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);

    }

    @Override
    protected View createSuccessView() {

        view = CommonUtils.inflate(R.layout.category_fragment_layout);

        listview_category_fragment = (ListView) view.findViewById(R.id.listview_category_fragment);
        recyclerview_category_fragment = (RecyclerView) view.findViewById(R.id.recyclerview_category_fragment);

        getWebData(Pathes.CommonTopPath, Pathes.FirstTopArgs, TOP);
        getWebData(Pathes.CommonContentPath, Pathes.FirstContentArgs, CONTENT);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    public void getWebData(String path, String args, final int flag) {
        new BaseDate(getActivity()) {
            @Override
            public void setResultError(ShowingPage.StateType stateLoadError) {

            }

            @Override
            public void setResultData(String data) {
                Gson gson = new Gson();
                CommunityContent communityContent = gson.fromJson(data, CommunityContent.class);
                if (flag == TOP) {
//                    Log.i("123321", communityContent.getData().get(2).getTitle() + "!!!!!!!!!!!!!!");
                    Message msgTop = Message.obtain();
                    msgTop.obj = communityContent;
                    msgTop.what = TOP;
                    handler.sendMessage(msgTop);
                } else if (flag == CONTENT) {

                    Message msgContent = Message.obtain();
                    msgContent.obj = communityContent;
                    msgContent.what = CONTENT;
                    handler.sendMessage(msgContent);
                }
            }
        }.getDate(path, args, flag, 0);
    }


}
