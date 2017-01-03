package com.explem.smalllemonade.bean;

/**
 * Created by asus on 2016/12/30.
 */

public class Home_Fragment_GiftBean {

    /**
     * code : 1
     * height : 0
     * success : true
     * width : 0
     * data : {"remark":"http://www.yulin520.com/a2a/h/i/yulin/h5_festival","name":"元旦节-  1.1","img":"http://img1.yulin520.com/news/JULIM57SWHT0OA56ZQ2N.png#210_210","holidayDetails":"http://www.yulin520.com/a2a/h/i/app/next_festival","festivalTime":1483200000000,"festivalId":6}
     * message : 2222
     */

    private int code;
    private int height;
    private boolean success;
    private int width;
    /**
     * remark : http://www.yulin520.com/a2a/h/i/yulin/h5_festival
     * name : 元旦节-  1.1
     * img : http://img1.yulin520.com/news/JULIM57SWHT0OA56ZQ2N.png#210_210
     * holidayDetails : http://www.yulin520.com/a2a/h/i/app/next_festival
     * festivalTime : 1483200000000
     * festivalId : 6
     */

    private DataBean data;
    private String message;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private String remark;
        private String name;
        private String img;
        private String holidayDetails;
        private long festivalTime;
        private int festivalId;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getHolidayDetails() {
            return holidayDetails;
        }

        public void setHolidayDetails(String holidayDetails) {
            this.holidayDetails = holidayDetails;
        }

        public long getFestivalTime() {
            return festivalTime;
        }

        public void setFestivalTime(long festivalTime) {
            this.festivalTime = festivalTime;
        }

        public int getFestivalId() {
            return festivalId;
        }

        public void setFestivalId(int festivalId) {
            this.festivalId = festivalId;
        }
    }
}
