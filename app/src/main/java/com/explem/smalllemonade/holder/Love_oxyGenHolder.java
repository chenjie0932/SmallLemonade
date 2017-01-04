package com.explem.smalllemonade.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.explem.smalllemonade.R;

/**
 * Created by asus on 2017/1/2.
 */

public class Love_oxyGenHolder extends RecyclerView.ViewHolder {

    public final ImageView home_fragment_love_oxygen_img3;
    public final TextView home_fragment_love_oxygen_title;
    public final TextView home_fragment_love_oxygen_contentInter;
    public final TextView home_fragment_love_oxygen_author;

    public Love_oxyGenHolder(View itemView) {
        super(itemView);
        home_fragment_love_oxygen_img3 = (ImageView) itemView.findViewById(R.id.home_fragment_love_oxygen_img3);
        home_fragment_love_oxygen_title = (TextView) itemView.findViewById(R.id.home_fragment_love_oxygen_title);
        home_fragment_love_oxygen_contentInter = (TextView) itemView.findViewById(R.id.home_fragment_love_oxygen_contentInter);
        home_fragment_love_oxygen_author = (TextView) itemView.findViewById(R.id.home_fragment_love_oxygen_author);
    }
}
