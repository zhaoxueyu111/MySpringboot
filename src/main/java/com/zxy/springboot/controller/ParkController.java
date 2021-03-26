package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.Park;
import com.zxy.springboot.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/park")
@CrossOrigin
public class ParkController {
    @Autowired
    private ParkService parkService;

    @RequestMapping("getBynamekey")
    @ResponseBody
    public ArrayList<Park> getByNameKey(String nameKey){
        return parkService.getByNameKey(nameKey);
    }

    @RequestMapping("getByParkState")
    @ResponseBody
    public ArrayList<Park> getByParkState(String parkState){
        return parkService.getByParkState(parkState);
    }

    @RequestMapping("getByParkArea")
    @ResponseBody
    public ArrayList<Park> getByParkArea(String parkarea){
        return parkService.getByParkArea(parkarea);
    }

}
