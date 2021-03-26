package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Device;
import com.zxy.springboot.pojo.Meter;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
@Mapper
public interface MeterDao {
    /**
     * 根据名称查询仪表
     */
    @Select("select * from t_meters where mname=#{name}")
    Meter getByMeterName(String name);
    /**
     * 根据类型查询仪表
     */
    @Select("select * from t_meters where mtype=#{type}")
    ArrayList<Meter> getByMeterType(String mtype);
    /**
     * 根据关键字查询仪表
     */
    @Select("select * from t_meters where mname like #{meternameKey}")
    ArrayList<Meter> getByMeterNameKey(String meternameKey);
    /**
     * 删除单个仪表
     */
    @Delete("delete from t_meters where mid=#{mid}")
    int deleteById(String mid);
    /**
     * 删除多个仪表
     */
    @Delete("delete from t_meters where mid in (${mids})")
    int deleteMore(@Param("mids") String mids);
    /**
     * 更新仪表信息
     */
    @Update("update t_meters set mname=#{mname},mtype=#{mtype},minquantity=#{minquantity} , mwarperiod=#{mwarperiod},mremark=#{mremark} where mid=#{mid}")
    int updateMeter(@Param("mid") int mid , @Param("mname") String mname , @Param("mtype") String mtype , @Param("minquantity")String minquantity, @Param("mwarperiod") String mwarperiod, @Param("mremark") String mremark) ;
    /**
     * 仪表名是否存在校验
     */
    @Select("select * from t_meters where mname=#{mname}")
    Meter meterCheck(String meter);
}
