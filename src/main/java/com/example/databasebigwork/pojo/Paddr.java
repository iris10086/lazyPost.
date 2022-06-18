package com.example.databasebigwork.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Paddr {
    @JsonProperty("postId")
    private String pid;
    @JsonProperty("postName")
    private String pname;
    @JsonProperty("postStation")
    private String pStation;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getpStation() {
        return pStation;
    }

    public void setpStation(String pStation) {
        this.pStation = pStation;
    }
}
