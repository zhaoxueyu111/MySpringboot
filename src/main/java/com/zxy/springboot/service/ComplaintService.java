package com.zxy.springboot.service;

import com.zxy.springboot.dao.ComplaintDao;
import com.zxy.springboot.pojo.Complaint;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;
    /**
     * 根据住户名模糊查询投诉情况
     * @param nameKey
     * @return
     */
    public ArrayList<Complaint> getByNameKey(String nameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(nameKey)) {
            param = "%" + nameKey + "%" ;
        }
        return complaintDao.getByNameKey(param) ;
    }
}
