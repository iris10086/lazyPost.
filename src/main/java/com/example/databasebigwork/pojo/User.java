package com.example.databasebigwork.pojo;

import java.util.ArrayList;

public class User {
    private String uid; // id
    private String username; // 用户名
    private String phone; // 手机号
    private String head = "/res/head/default.jpg"; // 头像地址
    private int count; // 剩余积分
    private String desc = "什么都没留下..."; // 个性签名
    private String password;
    private ArrayList<UserAddress> myAddress;

    public ArrayList<UserAddress> getMyAddress() {
        return myAddress;
    }

    public void setMyAddress(ArrayList<UserAddress> myAddress) {
        this.myAddress = myAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", head='" + head + '\'' +
                ", count=" + count +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
