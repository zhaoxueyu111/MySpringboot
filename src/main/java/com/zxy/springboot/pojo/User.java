package com.zxy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String  uname, uemail,usex,uaddress;
    private int uage,uid;
    @JsonIgnore
    private String upwd;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date utime;

    public User() {
    }

    public User(int uid, String uname, String upwd, String uemail, Date utime,String usex,String uaddress , int uage) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.uemail = uemail;
        this.utime = utime;
        this.usex = usex;
        this.uaddress=uaddress;
        this.uage = uage;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", uemail='" + uemail + '\'' +
                ", usex='" + usex + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", uage=" + uage +
                ", upwd='" + upwd + '\'' +
                ", utime=" + utime +
                '}';
    }


}
