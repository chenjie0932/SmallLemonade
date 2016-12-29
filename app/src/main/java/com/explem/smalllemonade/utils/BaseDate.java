package com.explem.smalllemonade.utils;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.explem.smalllemonade.bean.CacheBean;
import com.explem.smalllemonade.sql.Dao;
import com.explem.smalllemonade.view.ShowingPage;

import java.io.File;
import java.util.ArrayList;

import static com.explem.smalllemonade.fragment.HomeFragment.data;


/**
 * Created by Pooh on 2016/11/29.
 */
public abstract class BaseDate {

    public static int NOTIME=0;

    public static int NOMALTIME=24*3*60*60*1000;

    public static File cacheDir;
    private final Dao dao;
    private final Context context;

    public BaseDate(Context context){
        this.context=context;
        //得到数据库的管理类
        dao = new Dao(context);
    }
    /**
     * 这个方法供外面调用
     * @param path 路径
     * @param args 参数
     * @param index 索引
     * @param validTime 有效时间
     */
    public void getDate(String path, String args, int index, int validTime){
        //判断请求时间
        if(validTime==0){
            //直接请求网络
            getDataFromNet(path,args,index,validTime);
        }else{
            //数据库的查询方法
            ArrayList<CacheBean> list=dao.selectCache();
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getPath().equals(path+args)){
                    long myTime=Long.parseLong(list.get(i).getTime());
                    //从数据库中拿到数据
                    if(System.currentTimeMillis()<myTime){
                        data=list.get(i).getName();
                    }else{
                        //直接请求网络
                        getDataFromNet(path,args,index,validTime);
                    }
                }
            }
            if(TextUtils.isEmpty(data)){
                getDataFromNet(path,args,index,validTime);
            }else{
                //请求到数据，作返回
                setResultData(data);
            }
        }
    }

    /**
     * 网络获取----volley
     * @param path
     * @param args
     * @param index
     * @param validTime
     */
    private void getDataFromNet(final String path, final String args, final int index, final int validTime) {
        RequestQueue mQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(path+"?"+args,
                new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                final String data=s;
                //设置数据
                CommonUtils.runOnMainThread(new Runnable() {
                    @Override
                    public void run() {
                        setResultData(data);
                    }
                });

                //保存到数据库
                //先查询数据库
                ArrayList<CacheBean> list=dao.selectCache();
                if(list!=null){
                    boolean flag=false;
                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i).getPath().equals(path+args)){
                            dao.updateCache(new CacheBean(path+args,data,System.currentTimeMillis()+validTime+"","11"),list.get(i).getPath());
                            flag=true;
                        }
                    }
                    if(!flag){
                        dao.addCache(new CacheBean(path+args,data,System.currentTimeMillis()+validTime+"","11"));
                    }
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                //设置错误界面
                setResultError(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        });
        mQueue.add(stringRequest);
    }
    //请求错误时返回的方法
    protected abstract void setResultError(ShowingPage.StateType stateLoadError);
    //请求成功时返回的方法
    public abstract void setResultData(String data);
}
