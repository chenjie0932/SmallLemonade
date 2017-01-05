package com.explem.smalllemonade.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.explem.smalllemonade.R;

import static com.explem.smalllemonade.R.id.home_fragment_love_oxygen_author;

/**
 * Created by asus on 2017/1/2.
 */

public class Love_oxyGenHolder2 extends RecyclerView.ViewHolder {

    public final ImageView home_fragment_love_oxygen_img8;
    public final TextView home_fragment_love_oxygen_title2;
    public final TextView home_fragment_love_oxygen_contentInter;
    public final TextView home_fragment_love_oxygen_author2;

    public Love_oxyGenHolder2(View itemView) {
        super(itemView);
        home_fragment_love_oxygen_img8 = (ImageView) itemView.findViewById(R.id.home_fragment_love_oxygen_img3);
        home_fragment_love_oxygen_title2 = (TextView) itemView.findViewById(R.id.home_fragment_love_oxygen_title);
        home_fragment_love_oxygen_contentInter = (TextView) itemView.findViewById(R.id.home_fragment_love_oxygen_contentInter);
        home_fragment_love_oxygen_author2 = (TextView) itemView.findViewById(home_fragment_love_oxygen_author);

    }
}
