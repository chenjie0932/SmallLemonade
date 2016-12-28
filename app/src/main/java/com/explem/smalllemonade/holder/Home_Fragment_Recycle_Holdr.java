package com.explem.smalllemonade.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.explem.smalllemonade.R;

/**
 * Created by asus on 2016/12/28.
 */

public class Home_Fragment_Recycle_Holdr extends RecyclerView.ViewHolder {

    public final TextView home_fragment__note_recycle_item_tv;

    public Home_Fragment_Recycle_Holdr(View itemView) {
        super(itemView);
        home_fragment__note_recycle_item_tv = (TextView) itemView.findViewById(R.id.home_fragment__note_recycle_item_tv);
    }
}
