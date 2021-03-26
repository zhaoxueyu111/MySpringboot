package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Device;
import com.zxy.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface DeviceDao {
    /**
     * 根据名称查询设备
     */
    @Select("select * from t_devices where ddevice=#{device}")
    Device getByDeviceName(String name);
    /**
     * 根据关键字查询设备
     */
    @Select("select * from t_devices where ddevice like #{devicenameKey}")
    ArrayList<Device> getByDeviceNameKey(String devicenameKey);
    /**
     * 删除单个设备
     */
    @Delete("delete from t_devices where did=#{did}")
    int deleteById(String did);
    /**
     * 删除多个设备
     */
    @Delete("delete from t_devices where did in (${dids})")
    int deleteMore(@Param("dids") String dids);
    /**
     * 更新设备信息
     */
    @Update("update t_devices set ddevice=#{ddevice},dnumber=#{dnumber},dprice=#{dprice} where did=#{did}")
    int updateDevice(@Param("did") int did , @Param("ddevice") String ddevice , @Param("dnumber") String dnumber , @Param("dprice")String dprice) ;
    /**
     * 设备名是否存在校验
     */
    @Select("select * from t_devices where ddevice=#{ddevice}")
    Device deviceCheck(String device);
    /**
     * 增加设备
     */
    @Insert("insert into t_devices values(#{did} ,#{ddevice} , #{dnumber} , #{dprice} , NOW())")
    int addDevice(@Param("did") int did , @Param("ddevice") String ddevice , @Param("dnumber") String dnumber , @Param("dprice") String dprice) ;
}
