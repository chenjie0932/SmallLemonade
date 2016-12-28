package com.explem.smalllemonade.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.explem.smalllemonade.bean.CacheBean;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by Pooh on 2016/12/28.
 */

public class Dao {
    private final MySql sql;
    public Dao(Context context) {
        sql = new MySql(context);
    }
    //缓存数据的查询方法
    ArrayList<CacheBean> listBack=new ArrayList<>();
    public ArrayList<CacheBean> selectCache(){
        //清空集合
        listBack.clear();
        //查询数据库
        SQLiteDatabase db = sql.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from xiaoningle",null);
        while (cursor.moveToNext()) {
            String path=cursor.getString(cursor.getColumnIndex("path"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String tag=cursor.getString(cursor.getColumnIndex("tag"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
            //存入到集合
            CacheBean bean=new CacheBean(path,name,time,tag);
            listBack.add(bean);
        }
        //关闭数据库
        db.close();
        return listBack;
    }
    //缓存数据的添加方法
    public void addCache(CacheBean bean){
        //添加数据库的数据方法
        SQLiteDatabase db = sql.getWritableDatabase();
        db.execSQL("insert into xiaoningle (path,name,tag,time) values(?,?,?,?)",new String[]{bean.getPath(),bean.getName(),bean.getTag(),bean.getTime()});
        //关闭数据库
        db.close();
    }
    //缓存数据的修改方法
    public void updateCache(CacheBean bean,String path){
        //添加数据库的数据方法
        SQLiteDatabase db = sql.getWritableDatabase();
        db.execSQL("update xiaoningle set path=?,name=?,tag=?,time=? where path=?",new String[]{bean.getPath(),bean.getName(),bean.getTag(),bean.getTime(),path});
        //关闭数据库
        db.close();
    }
    //缓存数据的删除方法
    public void deleteCache(String path){
        SQLiteDatabase db=sql.getWritableDatabase();
        db.execSQL("delete from xiaoningle where path=?",new Object[]{name});
        //关闭数据库
        db.close();
    }
}
