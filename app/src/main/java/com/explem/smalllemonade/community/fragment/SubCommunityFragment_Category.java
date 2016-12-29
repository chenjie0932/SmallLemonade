package com.explem.smalllemonade.community.fragment;

import android.view.View;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.fragment.MineFragment;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.view.ShowingPage;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class SubCommunityFragment_Category extends BaseFragment {
    @Override
    protected void onload() {
        SubCommunityFragment_Category.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);


    }

    @Override
    protected View createSuccessView() {
        View view = CommonUtils.inflate(R.layout.subcommunityfragment_category);

        return view;
    }
}
