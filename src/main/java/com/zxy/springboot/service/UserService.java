package com.zxy.springboot.service;


import com.zxy.springboot.dao.UserDao;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Cacheable("user")
public class UserService {
    @Autowired
    private UserDao userDao ;
    /**
     * 登录校验
     */
    public User loginCheck(String name , String pass){
        // 数据过滤处理
        if(StringUtil.isEmpty(name)) {
            return null ;
        }
        if(StringUtil.isEmpty(pass)) {
            return null ;
        }
        // 连接数据库进行数据逻辑处理
        return userDao.loginCheck(name , pass) ;
    }

    /**
     * 新增用户
     * @return
     *
     *      -1 ： 注册信息不完整
     *      -2 ： 用户名已存在
     *      -3 ： 邮箱已存在
     *      -4 : 只能填写man或woman
     *      1 ： 注册成功
     *      0 ： 注册失败
     */
    public int addUser(String name , String pass , String email , String sex,String address,Integer age) {
        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(pass) || StringUtil.isEmpty(email)) {
            return -1 ;
        }
        // 检查用户名是否可用
        User user = userDao.nameCheck(name) ;
        if(null != user) {   // 说明根据名字能够找到有效用户，也就是说当前注册的用户名不可用
            return -2 ;
        }
        user = userDao.emailCheck(email) ;
        if(null != user) {
            return -3 ;
        }
       // if((sex!=new String("woman"))||(sex!= new String("man"))){
        //    return -4;
       // }
        return userDao.addUser(name , pass , email ,sex,address ,age) ;
    }



    /**
     * 删除一个用户
     */
    public int deleteById(String uid) {
        if(StringUtil.isEmpty(uid)) {
            return 0 ;
        }
        return userDao.deleteById(uid) ;
    }
    /**
     *
     * 删除多个用户
     *
     */
    public int deleteMore(String[] uidArr) {
        if(null == uidArr || uidArr.length == 0) {
            return 0 ;
        }
        // 将该数组处理为 'uid1' , 'uid2' , ... 格式的字符串
        String uids = "" ;
        for(int i = 0 ;i < uidArr.length ;i++) {
            uids += "'" + uidArr[i] + "'" + "," ;
        }
        // 拼接好的uids末尾多了一个 "," , 去掉该逗号
        uids = uids.substring(0 , uids.length() - 1) ;
        return userDao.deleteMore(uids) ;
    }
    /**
     * 用户修改密码
     * -1 -- 原密码错误
     * -2 -- 信息不完整
     * 1 --  修改成功
     * 0 -- 修改失败
     */
    public int repass(String uname , String oldPass , String newPass) {
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(oldPass) || StringUtil.isEmpty(newPass) ) {
            return -2 ;
        }
        User user = userDao.passCheck(uname , oldPass) ;
        if(null == user) {
            return -1 ;
        }
        return userDao.repass(uname , newPass) ;
    }

    /**
     * 按照名字关键字搜索用户
     */

    public ArrayList<User> getByNameKey(String nameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(nameKey)) {
            param = "%" + nameKey + "%" ;
        }
        return userDao.getByNameKey(param) ;
    }

    public User getByName(String name ){
        return userDao.getByName(name);
    }

    /**
     * 1 -- 修改成功
     * 其他——修改失败
     */
    public int updateUser(int uid , String uname , String uemail , String uaddress, String uage) {
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(uemail) || StringUtil.isEmpty(uaddress)|| StringUtil.isEmpty(uage) || uid<1) {
            return 0 ;
        }
        return userDao.updateUser(uid , uname , uemail , uaddress , uage) ;
    }
}
