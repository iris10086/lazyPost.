package com.example.databasebigwork.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Order {

    private String orderId;
    // 发布人信息
    private String issuerId;
    private String issuerName;
    //private String sphone;
    private String shead;
    // 接收人信息
    private String ruid;
    private String rusername;
    private String rphone;
    private String rhead;
    // 驿站信息
    private String pid;
    private String postName;
    private String postAddress;
    // 用户地址信息
    private String addressId;
    private String recipient;
    private String detailAddress;
    private String phone;
    // 订单信息
    @JsonFormat(pattern="MM月dd日 HH:mm",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern="MM月dd日 HH:mm",timezone = "GMT+8")
    private Date endTime;
    private int status;
    private int value;
    private int size;
    private String note;
    private String getExpressWay;

    @JsonProperty("orderId")
    public String getOid() {
        return orderId;
    }

    @JsonProperty("orderId")
    public void setOid(String oid) {
        this.orderId = oid;
    }

    @JsonProperty("issuerId")
    public String getSuid() {
        return issuerId;
    }

    @JsonProperty("issuerId")
    public void setSuid(String suid) {
        this.issuerId = suid;
    }

    @JsonProperty("issuerName")
    public String getSusername() {
        return issuerName;
    }

    @JsonProperty("issuerName")
    public void setSusername(String susername) {
        this.issuerName = susername;
    }

//    public String getSphone() {
//        return sphone;
//    }
//
//    public void setSphone(String sphone) {
//        this.sphone = sphone;
//    }

    @JsonProperty("shead")
    public String getShead() {
        return shead;
    }

    @JsonProperty("shead")
    public void setShead(String shead) {
        this.shead = shead;
    }


    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    @JsonProperty("rusername")
    public String getRusername() {
        return rusername;
    }

    @JsonProperty("rusername")
    public void setRusername(String rusername) {
        this.rusername = rusername;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRhead() {
        return rhead;
    }

    public void setRhead(String rhead) {
        this.rhead = rhead;
    }

    @JsonProperty("postId")
    public String getPid() {
        return pid;
    }

    @JsonProperty("postId")
    public void setPid(String pid) {
        this.pid = pid;
    }

    @JsonProperty("postName")
    public String getPname() {
        return postName;
    }

    @JsonProperty("postName")
    public void setPname(String pname) {
        this.postName = pname;
    }

    @JsonProperty("postAddress")
    public String getPaddr() {
        return postAddress;
    }

    @JsonProperty("postAddress")
    public void setPaddr(String paddr) {
        this.postAddress = paddr;
    }

    @JsonProperty("addressId")
    public String getUaid() {
        return addressId;
    }

    @JsonProperty("addressId")
    public void setUaid(String uaid) {
        this.addressId = uaid;
    }

    @JsonProperty("recipient")
    public String getUaiduaname() {
        return recipient;
    }

    @JsonProperty("recipient")
    public void setUaiduaname(String uaiduaname) {
        this.recipient = uaiduaname;
    }

    @JsonProperty("detailAddress")
    public String getUaaddr() {
        return detailAddress;
    }

    @JsonProperty("detailAddress")
    public void setUaaddr(String uaaddr) {
        this.detailAddress = uaaddr;
    }

    @JsonProperty("phone")
    public String getUaphone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setUaphone(String uaphone) {
        this.phone = uaphone;
    }

    @JsonProperty("startTime")
    public Date getStime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStime(Date stime) {
        this.startTime = stime;
    }


    @JsonProperty("endTime")
    public Date getEtime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEtime(Date etime) {
        this.endTime = etime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @JsonProperty("value")
    public int getCoin() {
        return value;
    }

    @JsonProperty("value")
    public void setCoin(int coin) {
        this.value = coin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("getExpressWay")
    public String getGet_way() {
        return getExpressWay;
    }

    @JsonProperty("getExpressWay")
    public void setGet_way(String get_way) {
        this.getExpressWay = get_way;
    }
}
