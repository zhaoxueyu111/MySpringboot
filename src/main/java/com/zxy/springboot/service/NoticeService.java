package com.zxy.springboot.service;

import com.zxy.springboot.dao.NoticeDao;
import com.zxy.springboot.pojo.Notice;
import com.zxy.springboot.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    public Map<String , Object> getBytitlePage(String titleKey , int page , int size) {
        String tKey = "%" ;
        if(!StringUtil.isEmpty(titleKey)) {
            tKey = "%" + titleKey + "%" ;
        }
        int offset = (page - 1) * size ;

        ArrayList<Notice> rows = noticeDao.getBytitle(tKey , offset , size) ;
        int count = noticeDao.getBytitleCount(tKey) ;
        //total属性和rows属性
        Map<String , Object> map = new HashMap<>() ;
        map.put("total" , count) ;
        map.put("rows" , rows) ;
        return  map ;
    }

    public Notice getById(int id) {
        return noticeDao.getByid(id) ;
    }

    /**
     * 1 -- 修改成功
     * 其他——修改失败
     */
    public int updateNotice(int id , String title , String content , String notes) {
        if(StringUtil.isEmpty(title) || StringUtil.isEmpty(content) || id < 1) {
            return 0 ;
        }
        return noticeDao.updateNotice(id , title , content , notes) ;
    }
}
