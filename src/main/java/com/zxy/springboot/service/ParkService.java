package com.zxy.springboot.service;

import com.zxy.springboot.dao.ParkDao;
import com.zxy.springboot.pojo.Park;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ParkService {
    @Autowired
    private ParkDao parkDao;
    /**
     * 根据住户名模糊查询
     * @param nameKey
     * @return
     */
    public ArrayList<Park> getByNameKey(String nameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(nameKey)) {
            param = "%" + nameKey + "%" ;
        }
        return parkDao.getByNameKey(param) ;
    }
    /**
     * 根据停车状态模糊查询
     * @param parkState
     * @return
     */
    public ArrayList<Park> getByParkState(String parkState){
        return parkDao.getByParkState(parkState);
    }
    /**
     * 根据停车类型模糊查询
     * @param parkarea
     * @return
     */
    public ArrayList<Park> getByParkArea(String parkarea){
        return parkDao.getByParkArea(parkarea);
    }
}
