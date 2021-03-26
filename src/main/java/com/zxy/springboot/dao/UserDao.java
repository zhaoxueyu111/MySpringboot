package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 针对数据库中Users表进行操作
 */
@Mapper
@EnableCaching
public interface UserDao {
    /**
     * 登陆检测
     * 返回User对象；如果登陆成功，该对象实例化
     */
    @Select("select * from t_users where uname=#{name} and upwd=#{password}")
    User loginCheck(@Param("name") String name, @Param("password") String password);
    /**
     * 用户名是否存在校验
     */
    @Select("select * from t_users where uname=#{name}")
    User nameCheck(String name);
    /**
     * 邮箱是否存在校验
     */
    @Select("select * from t_users where uemail=#{email}")
    User emailCheck(String email);

    @Select("select * from t_users where usex=#{sex}")
    User sexCheck(String sex);

    @Insert("insert into t_users(uname,upwd,uemail,usex,uaddress,uage,utime) values( #{name} , #{pwd} , #{email} ,#{sex},#{address},#{age}, NOW())")
    int addUser(@Param("name") String name , @Param("pwd") String pwd , @Param("email") String email , @Param("sex") String sex,@Param("address")String address,@Param("age") Integer age) ;

    /**
     * 按照名字关键字进行模糊查询数据，查询结果按照注册日期从小到大显示
     *
     */
    @Select("select * from t_users where uname like #{nameKey}")
    ArrayList<User> getByNameKey(String nameKey);


    @Select("select * from t_users where uname=#{name}")
    User getByName(String name);
    /**
    * 删除单个用户
    */



    @Delete("delete from t_users where uid=#{uid}")
    int deleteById(String uid);


    @Delete("delete from t_users where uid in (${uids})")
    int deleteMore(@Param("uids") String uids);

    /**
     * 密码校验
     */
    @Select("select * from t_users where uname=#{uname} and upwd=#{upwd}")
    User passCheck(@Param("uname") String uname , @Param("upwd") String upwd) ;

    /**
     * 修改密码
     */
    @Update("update t_users set upwd=#{newPwd} where uname=#{uname}")
    int repass(@Param("uname") String uname , @Param("newPwd")String newPwd) ;

    /**
     * 更新用户信息
     */
    @Update("update t_users set uname=#{uname} , uemail=#{uemail} ,uaddress=#{uaddress} ,uage=#{uage} where uid=#{uid}")
    int updateUser(@Param("uid") int uid , @Param("uname")String uname ,@Param("uemail")String uemail,@Param("uaddress")String uaddress,@Param("uage")String uage) ;
}
