package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.Asset;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/asset")
@CrossOrigin
public class AssetController {
    @Autowired
    private AssetService assetService;

    @RequestMapping("queryAsset")
    @ResponseBody
    public User queryAsset(String username){
        return assetService.queryAsset(username);
    }

    @RequestMapping("getBynamekey")
    @ResponseBody
    public ArrayList<Asset> getByNameKey(String nameKey){
        return assetService.getByNameKey(nameKey);
    }
}
