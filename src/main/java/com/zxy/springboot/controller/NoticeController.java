package com.zxy.springboot.controller;

import com.zxy.springboot.pojo.Notice;
import com.zxy.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
    @Controller
    @RequestMapping("/notice")
    @CrossOrigin
    public class NoticeController {
        @Autowired
        private NoticeService noticeService ;

        @RequestMapping("getData")
        @ResponseBody
        public Map<String , Object> getData(String title , @RequestParam("pageNumber") int page , @RequestParam("pageSize") int size) {
            return noticeService.getBytitlePage(title , page , size) ;
        }

        @RequestMapping("getByid")
        @ResponseBody
        public Notice getByid(int id) {
            return noticeService.getById(id) ;
        }

        @RequestMapping("update")
        @ResponseBody
        public String update(int id , String title , String content , String notes) {
            return noticeService.updateNotice(id , title , content , notes) > 0 ? "true" : "false" ;
        }
}
