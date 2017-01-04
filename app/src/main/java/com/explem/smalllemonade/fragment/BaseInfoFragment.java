package com.explem.smalllemonade.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.UapdateNameAcitvity;
import com.explem.smalllemonade.utils.CommonUtils;
import com.explem.smalllemonade.utils.StartUtils;

/**
 * Created by ${薛亚南}
 * on 2016/12/29 18：18.
 */

public class BaseInfoFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView img_baseicon;
    private TextView tv_baseBrDay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.baseinfo_fragment, null);
        intiView();
        return view;
    }

    public void intiView() {
        view.findViewById(R.id.bf_reIcon).setOnClickListener(this);
        view.findViewById(R.id.bf_reBrDay).setOnClickListener(this);
        view.findViewById(R.id.bf_reLove).setOnClickListener(this);
        view.findViewById(R.id.bf_reName).setOnClickListener(this);
        view.findViewById(R.id.bf_reWork).setOnClickListener(this);
        //头像
        img_baseicon = (ImageView) view.findViewById(R.id.img_baseicon);
        //生日
        tv_baseBrDay = (TextView) view.findViewById(R.id.tv_BaseBrDay);
        //情感状态
        tv_baseBrDay = (TextView) view.findViewById(R.id.tv_BaseLoveState);
        //姓名
        tv_baseBrDay = (TextView) view.findViewById(R.id.tv_BaseName);
        //星座
        tv_baseBrDay = (TextView) view.findViewById(R.id.tv_BaseStar);
        //工作
        tv_baseBrDay = (TextView) view.findViewById(R.id.tv_BaseWork);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //头像
            case R.id.bf_reIcon:
                break;
            //昵称
            case R.id.bf_reName:
                CommonUtils.jump(getActivity(), UapdateNameAcitvity.class,0);
                break;
            //生日
            case R.id.bf_reBrDay:
                break;
            //情感状态
            case R.id.bf_reLove:
                CommonUtils.jump(getActivity(), UapdateNameAcitvity.class,1);
                break;
            //工作
            case R.id.bf_reWork:
                CommonUtils.jump(getActivity(), UapdateNameAcitvity.class,2);
                break;
        }
    }
}
