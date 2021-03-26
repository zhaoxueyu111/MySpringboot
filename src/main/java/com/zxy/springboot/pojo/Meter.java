package com.zxy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Meter {
    private String mname,mtype,mwarperiod,mremark;
    private int mid,minquantity;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mtime;

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getMwarperiod() {
        return mwarperiod;
    }

    public void setMwarperiod(String mwarperiod) {
        this.mwarperiod = mwarperiod;
    }

    public String getMremark() {
        return mremark;
    }

    public void setMremark(String mremark) {
        this.mremark = mremark;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getMinquantity() {
        return minquantity;
    }

    public void setMinquantity(int minquantity) {
        this.minquantity = minquantity;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        return "Meter{" +
                "mname='" + mname + '\'' +
                ", mtype='" + mtype + '\'' +
                ", mwarperiod='" + mwarperiod + '\'' +
                ", mremark='" + mremark + '\'' +
                ", mid=" + mid +
                ", minquantity=" + minquantity +
                ", mtime=" + mtime +
                '}';
    }
}
