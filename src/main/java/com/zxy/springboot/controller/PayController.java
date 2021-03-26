package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.User;
import com.zxy.springboot.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/pay")
@CrossOrigin
public class PayController {
    @Autowired
    private PayService payService;

    int cost=0;

    @RequestMapping("getByNameAndHousearea")
    @ResponseBody
    public ArrayList<User> getByNameAndHousearea(int uid,String username, int housearea ){
        return payService.getByNameAndHousearea(uid,username,housearea);
    }
    @RequestMapping("calculate")
    @ResponseBody
    public int calculate(@RequestBody int percost,@RequestBody int housearea){
        int cost=percost*housearea;
        return cost;
    }
}
