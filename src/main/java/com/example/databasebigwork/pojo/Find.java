package com.example.databasebigwork.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Find {
    /**
     * 0. 没选
     * 1. 1-50
     * 2. 51-100
     * 3. >100
     */
    private int coin;
    @JsonProperty("postId")
    private String pid;
    private int size;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
