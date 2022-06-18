package com.example.databasebigwork.pojo;


import java.util.Date;

public class Order1 {
    
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
    private Date startTime;
    private Date endTime;
    private int status;
    private int value;
    private int size;
    private String note;
    private String getExpressWay;

    public String getOid() {
        return orderId;
    }

    public void setOid(String oid) {
        this.orderId = oid;
    }

    public String getSuid() {
        return issuerId;
    }

    public void setSuid(String suid) {
        this.issuerId = suid;
    }

    public String getSusername() {
        return issuerName;
    }

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

    public String getShead() {
        return shead;
    }

    public void setShead(String shead) {
        this.shead = shead;
    }

    public String getRuid() {
        return ruid;
    }

    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    public String getRusername() {
        return rusername;
    }

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return postName;
    }

    public void setPname(String pname) {
        this.postName = pname;
    }

    public String getPaddr() {
        return postAddress;
    }

    public void setPaddr(String paddr) {
        this.postAddress = paddr;
    }

    public String getUaid() {
        return addressId;
    }

    public void setUaid(String uaid) {
        this.addressId = uaid;
    }

    public String getUaiduaname() {
        return recipient;
    }

    public void setUaiduaname(String uaiduaname) {
        this.recipient = uaiduaname;
    }

    public String getUaaddr() {
        return detailAddress;
    }

    public void setUaaddr(String uaaddr) {
        this.detailAddress = uaaddr;
    }

    public String getUaphone() {
        return phone;
    }

    public void setUaphone(String uaphone) {
        this.phone = uaphone;
    }

    public Date getStime() {
        return startTime;
    }

    public void setStime(Date stime) {
        this.startTime = stime;
    }

    public Date getEtime() {
        return endTime;
    }

    public void setEtime(Date etime) {
        this.endTime = etime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCoin() {
        return value;
    }

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

    public String getGet_way() {
        return getExpressWay;
    }

    public void setGet_way(String get_way) {
        this.getExpressWay = get_way;
    }
}
