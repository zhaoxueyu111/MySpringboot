package com.zxy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Device {
    private String did,dnumber,dprice;
    private String ddevice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dtime;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDnumber() {
        return dnumber;
    }

    public void setDnumber(String dnumber) {
        this.dnumber = dnumber;
    }

    public String getDprice() {
        return dprice;
    }

    public void setDprice(String dprice) {
        this.dprice = dprice;
    }

    public String getDdevice() {
        return ddevice;
    }

    public void setDdevice(String ddevice) {
        this.ddevice = ddevice;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    @Override
    public String toString() {
        return "Device{" +
                "did=" + did +
                ", dnumber=" + dnumber +
                ", dprice=" + dprice +
                ", ddevice='" + ddevice + '\'' +
                ", dtime=" + dtime +
                '}';
    }
}
