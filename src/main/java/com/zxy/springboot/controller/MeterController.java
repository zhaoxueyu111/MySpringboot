package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.Meter;
import com.zxy.springboot.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/meter")
@CrossOrigin
public class MeterController {
    @Autowired
    private MeterService meterService ;

    @RequestMapping("getByMeterName")
    @ResponseBody
    public Meter getByMeterName(String name){
        return meterService.getByMeterName(name);
    }

    @RequestMapping("getByMeterType")
    @ResponseBody
    public ArrayList<Meter> getByMeterType(String type){
        return meterService.getByMeterType(type);
    }

    @RequestMapping("getByMeterNameKey")
    @ResponseBody
    public ArrayList<Meter> getByDeviceNameKey(String meternameKey){
        return meterService.getByMeterNameKey(meternameKey);
    }

    @RequestMapping("deleteOne")
    @ResponseBody
    public String deleteOne(String deleteMid){
        return meterService.deleteById(deleteMid) > 0 ? "true" : "false";
    }

    @RequestMapping("deleteMore")
    @ResponseBody
    public String deleteMore(String[] mids) {
        for(int i = 0 ;i < mids.length ;i++) {
            System.out.println(mids[i]);
        }
        return meterService.deleteMore(mids) > 0 ? "true" : "false" ;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(int mid , String mname , String mtype , String minquantity, String mwarperiod,String mremark) {
        return meterService.updateMeter(mid , mname , mtype , minquantity, mwarperiod, mremark) > 0 ? "true" : "false" ;
    }
}
