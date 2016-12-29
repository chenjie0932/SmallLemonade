package com.explem.smalllemonade.community.fragment;

import android.view.View;
import android.widget.TextView;

import com.explem.smalllemonade.base.BaseFragment;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class SubCommunityFragment_Category extends BaseFragment {
    @Override
    protected void onload() {



    }

    @Override
    protected View createSuccessView() {

        TextView textView = new TextView(getActivity());
        textView.setText("板块");
        return null;
    }
}
