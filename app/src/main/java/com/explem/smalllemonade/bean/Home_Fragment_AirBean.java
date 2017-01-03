package com.explem.smalllemonade.bean;

import java.util.List;

/**
 * Created by asus on 2016/12/31.
 */

public class Home_Fragment_AirBean {

    /**
     * code : 1
     * data : [{"click":1917,"id":1992,"img":"http://img1.yulin520.com/news/RVH92M4H4F50O7XS0G4C.jpg#450_1125","indexImg":"","introduction":"在充满感恩、温暖与爱的圣诞期间，柠乐君将带你一起，踏上一段有笑有泪的《摆渡人》之旅。 ","replyTimes":2,"star":143,"title":"有奖征集 | 我有电影票，你有故事么？","type":26,"url":"http://www.yulin520.com/a2a/h/news/o/1992?a=1483160384028"}]
     * height : 0
     * success : true
     * width : 0
     */

    private int code;
    private int height;
    private boolean success;
    private int width;
    /**
     * click : 1917
     * id : 1992
     * img : http://img1.yulin520.com/news/RVH92M4H4F50O7XS0G4C.jpg#450_1125
     * indexImg :
     * introduction : 在充满感恩、温暖与爱的圣诞期间，柠乐君将带你一起，踏上一段有笑有泪的《摆渡人》之旅。
     * replyTimes : 2
     * star : 143
     * title : 有奖征集 | 我有电影票，你有故事么？
     * type : 26
     * url : http://www.yulin520.com/a2a/h/news/o/1992?a=1483160384028
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Home_Fragment_AirBean{" +
                "code=" + code +
                ", height=" + height +
                ", success=" + success +
                ", width=" + width +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private int click;
        private int id;
        private String img;
        private String indexImg;
        private String introduction;
        private int replyTimes;
        private int star;
        private String title;
        private int type;
        private String url;

        @Override
        public String toString() {
            return "DataBean{" +
                    "click=" + click +
                    ", id=" + id +
                    ", img='" + img + '\'' +
                    ", indexImg='" + indexImg + '\'' +
                    ", introduction='" + introduction + '\'' +
                    ", replyTimes=" + replyTimes +
                    ", star=" + star +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", url='" + url + '\'' +
                    '}';
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getIndexImg() {
            return indexImg;
        }

        public void setIndexImg(String indexImg) {
            this.indexImg = indexImg;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public int getReplyTimes() {
            return replyTimes;
        }

        public void setReplyTimes(int replyTimes) {
            this.replyTimes = replyTimes;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
