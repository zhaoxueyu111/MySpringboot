package com.zxy.springboot.service;

import com.zxy.springboot.dao.PayDao;
import com.zxy.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PayService {
    @Autowired
    PayDao payDao;

    public ArrayList<User> getByNameAndHousearea(int uid,String username, int housearea ) {
        return payDao.getByNameAndHousearea(uid,username,housearea);
    }
}
