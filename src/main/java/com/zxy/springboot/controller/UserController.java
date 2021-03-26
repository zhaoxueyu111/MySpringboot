package com.zxy.springboot.controller;

import com.sun.corba.se.spi.orbutil.fsm.Guard;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService ;



    @RequestMapping(value = "logincheck")
    @ResponseBody
    public User loginCheck(String username,String userpass ,HttpSession session) {
        session.setAttribute("username" ,username);
        return userService.loginCheck(username,userpass);
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //使session失效
        //session.invalidate();
        return "redirect:/Login.html";
    }

    @RequestMapping("adduser")
    @ResponseBody
    public Map<String , Object> addUser(String username , String userpass , String email , String sex,String address,Integer age) {
        //System.out.println(username);断点测试
        int r = userService.addUser(username , userpass , email ,sex,address ,age) ;
        String s = "" ;
        switch (r) {
            case 1 : s = "注册成功!" ; break;
            case -1 : s = "用户信息不完整!" ; break;
            case -2 : s = "用户名已存在!" ; break;
            case -3 : s = "邮件已存在!" ; break;
           // case -4 : s = "性别只能为man或woman" ;break;
            case 0 : s = "注册失败!" ; break;
        }
        Map<String , Object> map = new HashMap<>() ;
        map.put("code" , r) ;
        map.put("info" , s) ;
        return map ;
    }
    @RequestMapping("getBynamekey")
    @ResponseBody
    public ArrayList<User> getByNameKey(String nameKey){
        return userService.getByNameKey(nameKey);
    }


    @RequestMapping("deleteOne")
    @ResponseBody
    public String deleteOne(String deleteUid){
        return userService.deleteById(deleteUid) > 0 ? "true" : "false";
    }

    @RequestMapping("deleteMore")
    @ResponseBody
    public String deleteMore(String[] uids) {
        for(int i = 0 ;i < uids.length ;i++) {
            System.out.println(uids[i]);
        }
        return userService.deleteMore(uids) > 0 ? "true" : "false" ;
    }
    @RequestMapping("repass")
    @ResponseBody
    public Map<String , Object> repass(String uname , String oldPass , String newPass) {
        int r = userService.repass(uname , oldPass , newPass) ;
        String s = "" ;
        switch (r) {
            case 1 : s = "修改密码成功!" ; break;
            case -1 : s = "原密码错误!" ; break;
            case -2 : s = "信息不完整!" ; break;
            case 0 : s = "修改密码失败!" ; break;
        }
        Map<String , Object> map = new HashMap<>() ;
        map.put("code" , r) ;
        map.put("info" , s) ;
        return map ;
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateUser(int uid , String uname , String uemail , String uaddress , String uage) {
        return userService.updateUser(uid , uname , uemail, uaddress, uage) > 0 ? "true" : "false" ;
    }
}



















