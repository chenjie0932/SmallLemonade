package com.explem.smalllemonade.community.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.explem.smalllemonade.R;
import com.explem.smalllemonade.community.bean.CommunityContent;

import java.util.List;

/**
 * Created by Administrator on 2016/12/31 0031.
 */
public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyHolder> {

    private Context context;
    private List<CommunityContent.Data> list;

    public MyRecyclerView(FragmentActivity activity, List<CommunityContent.Data> data) {
        context = activity;
        list = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = CommonUtils.inflate(R.layout.subcommunityfragment_item);
        View view = LayoutInflater.from(context).inflate(R.layout.subcommunityfragment_item,parent,false);
        //View view = CommonUtils.inflate(R.layout.subcommunityfragment_item);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.tv_subcommunity_title.setText(list.get(position).getTitle());
        holder.tv_subcommunity_content.setText(list.get(position).getContent());
      //  holder.tv_subcommunity_name.setText(list.get(position).getUserName());
        holder.tv_subcommunity_name.setText(list.get(position).getId()+"");
        holder.tv_subcommunity_replyTimes.setText(list.get(position).getReplyTimes()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{

        public final TextView tv_subcommunity_title;
        public final TextView tv_subcommunity_content;
        public final TextView tv_subcommunity_name;
        public final TextView tv_subcommunity_replyTimes;

        public MyHolder(View itemView) {
            super(itemView);
            tv_subcommunity_title = (TextView) itemView.findViewById(R.id.tv_subcommunity_title);
            tv_subcommunity_content = (TextView) itemView.findViewById(R.id.tv_subcommunity_content);
            tv_subcommunity_name = (TextView) itemView.findViewById(R.id.tv_subcommunity_name);
            tv_subcommunity_replyTimes = (TextView) itemView.findViewById(R.id.tv_subcommunity_replyTimes);
        }
    }
}
