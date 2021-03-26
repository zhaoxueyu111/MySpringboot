package com.zxy.springboot.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Park {
    public String parkarea,parkstate,uname;
    public int pid,uid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ptime;


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getParkarea() {
        return parkarea;
    }

    public void setParkarea(String parkarea) {
        this.parkarea = parkarea;
    }

    public String getParkstate() {
        return parkstate;
    }

    public void setParkstate(String parkstate) {
        this.parkstate = parkstate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Park() {
    }

    public Park(String parkarea, String parkstate, int pid, Date ptime) {
        this.parkarea = parkarea;
        this.parkstate = parkstate;
        this.pid = pid;
        this.ptime = ptime;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkarea='" + parkarea + '\'' +
                ", parkstate='" + parkstate + '\'' +
                ", pid=" + pid +
                ", ptime=" + ptime +
                '}';
    }
}
