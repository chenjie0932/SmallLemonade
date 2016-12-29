package com.explem.smalllemonade.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.holder.Home_Fragment_Recycle_Holdr;

import java.util.List;

/**
 * Created by asus on 2016/12/28.
 */

public class Home_Fragment_Recycle_Adapter extends RecyclerView.Adapter<Home_Fragment_Recycle_Holdr> {

    private final Context context;
    private final List<String> list;

    public Home_Fragment_Recycle_Adapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public Home_Fragment_Recycle_Holdr onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.home_fragment_note_recycle_item, null);
        Home_Fragment_Recycle_Holdr holder=new Home_Fragment_Recycle_Holdr(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(Home_Fragment_Recycle_Holdr holder, int position) {
        holder.home_fragment__note_recycle_item_tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
