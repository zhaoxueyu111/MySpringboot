package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Asset;
import com.zxy.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface AssetDao{
    @Select("select t1.* , t2.uname from t_assets t1 , t_users t2  where t1.uid=t2.uid")
    User queryAsset(String username);

    @Select("select t1.*, t2.uname from t_assets t1 , t_users t2  where t1.uid=t2.uid and t2.uname like  #{nameKey} ")
    ArrayList<Asset> getByNameKey(String nameKey);
}
