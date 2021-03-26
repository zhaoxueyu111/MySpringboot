package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.Device;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.service.DeviceService;
import com.zxy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/device")
@CrossOrigin
public class DeviceController {
    @Autowired
    private DeviceService deviceService ;
    
    @RequestMapping("getByDeviceName")
    @ResponseBody
    public Device getByDeviceName(String name){
        return deviceService.getByDeviceName(name);
    }

    @RequestMapping("getByDeviceNameKey")
    @ResponseBody
    public ArrayList<Device> getByDeviceNameKey(String devicenameKey){
        return deviceService.getByDeviceNameKey(devicenameKey);
    }


    @RequestMapping("deleteOne")
    @ResponseBody
    public String deleteOne(String deleteDid){
        return deviceService.deleteById(deleteDid) > 0 ? "true" : "false";
    }

    @RequestMapping("deleteMore")
    @ResponseBody
    public String deleteMore(String[] dids) {
        for(int i = 0 ;i < dids.length ;i++) {
            System.out.println(dids[i]);
        }
        return deviceService.deleteMore(dids) > 0 ? "true" : "false" ;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(int did , String ddevice , String dnumber , String dprice) {
        return deviceService.updateDevice(did , ddevice , dnumber , dprice) > 0 ? "true" : "false" ;
    }

    @RequestMapping("addDevice")
    @ResponseBody
    public Map<String , Object> addDevice(int did , String ddevice , String dnumber, String dprice) {
        int r = deviceService.addDevice(did , ddevice , dnumber ,dprice) ;
        String s = "" ;
        switch (r) {
            case 1 : s = "添加成功!" ; break;
            case -1 : s = "添加设备信息不完整!" ; break;
            case -2 : s = "设备id不正确" ; break;
            case -3 : s = "设备名已存在" ; break;
            case 0 : s = "添加失败!" ; break;
        }
        Map<String , Object> map = new HashMap<>() ;
        map.put("code" , r) ;
        map.put("info" , s) ;
        return map ;
    }
}
