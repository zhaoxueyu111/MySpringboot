package com.zxy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Complaint {
    private String cinformation,cstate,uname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ctime;

    private int cid;

    public Complaint() {
    }

    public Complaint(String cinformation, String cstate, String uname, Date ctime, int cid) {
        this.cinformation = cinformation;
        this.cstate = cstate;
        this.uname = uname;
        this.ctime = ctime;
        this.cid = cid;
    }

    public String getCinformation() {
        return cinformation;
    }

    public void setCinformation(String cinformation) {
        this.cinformation = cinformation;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "cinformation='" + cinformation + '\'' +
                ", cstate='" + cstate + '\'' +
                ", uname='" + uname + '\'' +
                ", ctime=" + ctime +
                ", cid=" + cid +
                '}';
    }
}
