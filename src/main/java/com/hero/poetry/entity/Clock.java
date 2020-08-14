package com.hero.poetry.entity;


public class Clock {

    private int id;
    private String moothText;
    private String openid;
    private String image1;
    private String image2;
    private String address;
    private String sign;
    private String time;
    private String nickName;
    private String avatarUrl;

    public Clock() {
    }

    public Clock(String moothText, String openid, String image1, String image2, String address, String sign, String time, String nickName, String avatarUrl) {
        this.moothText = moothText;
        this.openid = openid;
        this.image1 = image1;
        this.image2 = image2;
        this.address = address;
        this.sign = sign;
        this.time = time;
        this.nickName = nickName;
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getMoothText() {
        return moothText;
    }

    public void setMoothText(String moothText) {
        this.moothText = moothText;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "id=" + id +
                ", moothText='" + moothText + '\'' +
                ", openid='" + openid + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", address='" + address + '\'' +
                ", sign='" + sign + '\'' +
                ", time='" + time + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
