package com.zxy.springboot.controller;


import com.zxy.springboot.pojo.Complaint;
import com.zxy.springboot.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/complaint")
@CrossOrigin
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("getBynamekey")
    @ResponseBody
    public ArrayList<Complaint> getByNameKey(String nameKey){
        return complaintService.getByNameKey(nameKey);
    }
}
