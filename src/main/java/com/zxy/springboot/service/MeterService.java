package com.zxy.springboot.service;



import com.zxy.springboot.dao.MeterDao;
import com.zxy.springboot.pojo.Meter;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MeterService {
    @Autowired
    private MeterDao meterDao;
    /**
     * 按照名字搜索仪表
     */
    public Meter getByMeterName(String name){
        return meterDao.getByMeterName(name);
    }
    /**
     * 按照名字关键字搜索仪表
     */
    public ArrayList<Meter> getByMeterNameKey(String meternameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(meternameKey)) {
            param = "%" + meternameKey + "%" ;
        }
        return meterDao.getByMeterNameKey(param) ;
    }
    /**
     * 按照类型搜索仪表
     */
    public ArrayList<Meter> getByMeterType(String mtype) {
        return meterDao.getByMeterType(mtype) ;
    }
    /**
     * 删除一个仪表
     */
    public int deleteById(String mid) {
        if(StringUtil.isEmpty(mid)) {
            return 0 ;
        }
        return meterDao.deleteById(mid) ;
    }
    /**
     * 删除多个仪表
     */
    public int deleteMore(String[] midArr) {
        if(null == midArr || midArr.length == 0) {
            return 0 ;
        }
        // 将该数组处理为 'mid1' , 'mid2' , ... 格式的字符串
        String mids = "" ;
        for(int i = 0 ;i < midArr.length ;i++) {
            mids += "'" + midArr[i] + "'" + "," ;
        }
        // 拼接好的mids末尾多了一个 "," , 去掉该逗号
        mids = mids.substring(0 , mids.length() - 1) ;
        return meterDao.deleteMore(mids) ;
    }
    /**
     * 1 -- 修改成功
     * 其他——修改失败
     */
    public int updateMeter(int mid , String mname , String mtype , String minquantity, String mwarperiod,String mremark) {
        if(StringUtil.isEmpty(mname) || StringUtil.isEmpty(mtype) || StringUtil.isEmpty(minquantity)|| mid < 1) {
            return 0 ;
        }
        return meterDao.updateMeter(mid , mname , mtype , minquantity, mwarperiod, mremark) ;
    }
}
