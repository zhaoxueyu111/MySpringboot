package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Complaint;
import com.zxy.springboot.pojo.Park;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface ComplaintDao {
    @Select("select t1.*, t2.uname from t_complaints t1 , t_users t2  where t1.cid=t2.uid and t2.uname like #{nameKey} ")
    ArrayList<Complaint> getByNameKey(String nameKey);
}
