package com.explem.smalllemonade.community.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.explem.smalllemonade.base.BaseFragment;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class SubCommunityFragment_Some extends BaseFragment {

    public int type;

    @Override
    protected void onload() {

//        Bundle bundle = getArguments();
//        type = bundle.getInt("type");

    }

    @Override
    protected View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText("精选");
        return textView;
    }


    public Fragment setFragment(int type){

        SubCommunityFragment_Some subCommunityFragment = new SubCommunityFragment_Some();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        subCommunityFragment.setArguments(bundle);
        return subCommunityFragment;
    }
}
