package com.explem.smalllemonade.bean;

/**
 * Created by Pooh on 2016/12/28.
 */

public class CacheBean {
    private String path;
    private String name;
    private String time;
    private String tag;

    public CacheBean(String path, String name, String time, String tag) {
        this.path = path;
        this.name = name;
        this.time = time;
        this.tag = tag;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
