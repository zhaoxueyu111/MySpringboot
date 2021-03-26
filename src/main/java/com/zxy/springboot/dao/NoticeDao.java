package com.zxy.springboot.dao;

import com.zxy.springboot.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
@Mapper
public interface NoticeDao {
    /**
     * offset是跳过记录个数
     * size是每页的记录个数
     */
    @Select("select * from tb_notice where title like #{titleKey} limit ${offset} , ${size}")
    ArrayList<Notice> getBytitle(@Param("titleKey") String titleKey , @Param("offset") int offset, @Param("size") int size) ;

    @Select("select count(*) from tb_notice where title like #{titleKey}")
    int getBytitleCount(String titleKey) ;

    @Select("select * from tb_notice where id=#{id}")
    Notice getByid(int id) ;

    @Update("update tb_notice set title=#{title},content=#{content},notes=#{notes} where id=#{id}")
    int updateNotice(@Param("id") int id , @Param("title") String title , @Param("content") String content , @Param("notes")String notes) ;
}
