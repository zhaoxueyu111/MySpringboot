package com.zxy.springboot.pojo;

import java.io.Serializable;

public class Asset implements Serializable {
    public int aid,income,savings,house,housearea,uid;

    public String uname;

    public int getHousearea() {
        return housearea;
    }

    public void setHousearea(int housearea) {
        this.housearea = housearea;
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

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "aid=" + aid +
                ", income=" + income +
                ", savings=" + savings +
                ", house=" + house +
                '}';
    }
}
