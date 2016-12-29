package com.explem.smalllemonade.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.base.BaseFragment;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.view.ShowingPage;

import static com.explem.smalllemonade.R.id.mf_icon;
import static com.explem.smalllemonade.R.id.mf_ivSex;
import static com.explem.smalllemonade.R.id.mf_reBaseInfo;
import static com.explem.smalllemonade.R.id.mf_reFeed;
import static com.explem.smalllemonade.R.id.mf_reMine;
import static com.explem.smalllemonade.R.id.mf_reSeting;
import static com.explem.smalllemonade.R.id.mf_tvNum;

/**
 * Created by Pooh on 2016/12/27.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private View mineView;
    private ImageView mf_icon, mf_ivSex;
    private TextView mf_tvName, mf_tvNum;


    @Override
    protected void onload() {
        //设置布局
        MineFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    protected View createSuccessView() {
        mineView = CommonUtils.inflate(R.layout.fragment_mine);
        initView();
        return mineView;
    }

    private void initView() {
        //头像
        mf_icon = (ImageView) mineView.findViewById(R.id.mf_icon);
        //昵称
        mf_tvName = (TextView) mineView.findViewById(R.id.mf_tvName);
        //性别
        mf_ivSex = (ImageView) mineView.findViewById(R.id.mf_ivSex);
        //关注数量
        mf_tvNum = (TextView) mineView.findViewById(R.id.mf_tvNum);

        mineView.findViewById(mf_reBaseInfo).setOnClickListener(this);
        mineView.findViewById(R.id.mf_reMine).setOnClickListener(this);
        mineView.findViewById(R.id.mf_reFeed).setOnClickListener(this);
        mineView.findViewById(R.id.mf_reSeting).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //基本资料
            case R.id.mf_reBaseInfo:
                break;
            //我的帖子
            case R.id.mf_reMine:
                break;
            //意见反馈
            case R.id.mf_reFeed:
                break;
            //设置
            case R.id.mf_reSeting:
                break;
        }

    }
}
