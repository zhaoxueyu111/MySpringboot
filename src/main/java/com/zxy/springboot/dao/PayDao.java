package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface PayDao {
    @Select("select t1.housearea, t2.* from t_assets t1 , t_users t2  where t1.uid=t2.uid  ")
    ArrayList<User> getByNameAndHousearea(int uid,String username,int  housearea);
}
