package com.zxy.springboot.service;

import com.zxy.springboot.dao.AssetDao;
import com.zxy.springboot.pojo.Asset;
import com.zxy.springboot.pojo.User;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AssetService {

    @Autowired
    private AssetDao assetDao;

    public User queryAsset(String username){
        return assetDao.queryAsset(username);
    }

    /**
     * 按照名字关键字搜索用户
     */

    public ArrayList<Asset> getByNameKey(String nameKey) {
        String param = "%" ;
        if(! StringUtil.isEmpty(nameKey)) {
            param = "%" + nameKey + "%" ;
        }
        return assetDao.getByNameKey(param) ;
    }
}
