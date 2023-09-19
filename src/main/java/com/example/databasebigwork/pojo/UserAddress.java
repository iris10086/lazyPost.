package com.example.databasebigwork.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户地址")
public class UserAddress {
//    @JsonProperty("addressId")
    @ApiModelProperty("地址ID")
    private String aid; // 地址id
    @ApiModelProperty("用户ID")
    private String uid; // user ID
    // @JsonProperty("recipient")
    @ApiModelProperty("收件人昵称")
    private String name; // 收件人昵称
    // @JsonProperty("detailAddress")
    private String address; // 地址描述
    private String phone; // 电话

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
