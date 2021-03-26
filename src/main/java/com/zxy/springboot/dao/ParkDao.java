package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Asset;
import com.zxy.springboot.pojo.Park;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ParkDao {
    /**
     * 根据停车车位类型查询
     *
     */
    @Select("select t1.*, t2.uname from t_parks t1 , t_users t2 where t1.pid=t2.uid and parkarea = #{parkarea}")
    ArrayList<Park> getByParkArea(String parkArea );
    /**
     * 根据停车状态类型查询
     *
     */
    @Select("select t1.*, t2.uname from t_parks t1 , t_users t2 where t1.pid=t2.uid and parkstate = #{parkstate}")
    ArrayList<Park> getByParkState(String parkState );


    @Select("select t1.*, t2.uname from t_parks t1 , t_users t2  where t1.pid=t2.uid and t2.uname like #{nameKey} ")
    ArrayList<Park> getByNameKey(String nameKey);
}
