package com.explem.smalllemonade.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.explem.smalllemonade.R;

/**
 * Created by asus on 2016/12/30.
 */

public class LoveRecycleHolder extends RecyclerView.ViewHolder {

    public final TextView home_fragment__love_recycle_tv;
    public final ImageView home_fragment__love_recycle_img;

    public LoveRecycleHolder(View itemView) {
        super(itemView);
        home_fragment__love_recycle_img = (ImageView) itemView.findViewById(R.id.home_fragment__love_recycle_img);
        home_fragment__love_recycle_tv = (TextView) itemView.findViewById(R.id.home_fragment__love_recycle_tv);
    }
}
