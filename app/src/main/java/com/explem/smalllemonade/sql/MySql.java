package com.explem.smalllemonade.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Pooh on 2016/12/28.
 */

public class MySql extends SQLiteOpenHelper{
    public MySql(Context context) {
        super(context, "xiaoningle", null, 1);
    }
    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table xiaoningle (path varchar(200),name varchar(20000),tag varchar(200),time varchar(200))");
    }
    //版本更新的方法
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
