package com.explem.smalllemonade.community.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29 0029.
 */

public class CommunityContent {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data{
        private String content;
        private String title;
        private String replyTimes;
        private int id;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getReplyTimes() {
            return replyTimes;
        }

        public void setReplyTimes(String replyTimes) {
            this.replyTimes = replyTimes;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
