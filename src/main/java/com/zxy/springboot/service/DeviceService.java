package com.zxy.springboot.service;

import com.zxy.springboot.dao.DeviceDao;
import com.zxy.springboot.pojo.Device;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    /**
     * 按照名字搜索物业设备
     */
    public Device getByDeviceName(String name){
        return deviceDao.getByDeviceName(name);
    }
    /**
     * 按照名字关键字搜索物业设备
     */
    public ArrayList<Device> getByDeviceNameKey(String devicenameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(devicenameKey)) {
            param = "%" + devicenameKey + "%" ;
        }
        return deviceDao.getByDeviceNameKey(param) ;
    }
    /**
     * 删除一个物业设备
     */
    public int deleteById(String did) {
        if(StringUtil.isEmpty(did)) {
            return 0 ;
        }
        return deviceDao.deleteById(did) ;
    }
    /**
     * 删除多个物业设备
     */
    public int deleteMore(String[] didArr) {
        if(null == didArr || didArr.length == 0) {
            return 0 ;
        }
        // 将该数组处理为 'did1' , 'did2' , ... 格式的字符串
        String dids = "" ;
        for(int i = 0 ;i < didArr.length ;i++) {
            dids += "'" + didArr[i] + "'" + "," ;
        }
        // 拼接好的dids末尾多了一个 "," , 去掉该逗号
        dids = dids.substring(0 , dids.length() - 1) ;
        return deviceDao.deleteMore(dids) ;
    }
    /**
     * 1 -- 修改成功
     * 其他——修改失败
     */
    public int updateDevice(int did , String ddevice , String dnumber , String dprice) {
        if(StringUtil.isEmpty(ddevice) || StringUtil.isEmpty(dnumber) || StringUtil.isEmpty(dprice)|| did < 1) {
            return 0 ;
        }
        return deviceDao.updateDevice(did , ddevice , dnumber , dprice) ;
    }
    /**
     * 增加设备
     * -1 : 增加设备信息不完整
     * -2 : 设备id不正确
     * -3 : 设备名已存在
     */
    public int addDevice(int did , String ddevice , String dnumber, String dprice) {
        if(StringUtil.isEmpty(ddevice) || StringUtil.isEmpty(dnumber) || StringUtil.isEmpty(dprice)) {
            return -1 ;
        }
        if (did < 0) {
            return -2;
        }
        // 检查设备名是否可用
        Device device = deviceDao.deviceCheck(ddevice) ;
        if(null != device) {   // 说明根据名字能够找到有效用户，也就是说当前设备名不可用
            return -3;
        }
        return deviceDao.addDevice(did, ddevice , dnumber ,dprice) ;
    }
}

