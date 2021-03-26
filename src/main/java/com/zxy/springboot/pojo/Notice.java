package com.zxy.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private int id ;
    private String title , content ;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "Asia/Shanghai")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pubdatetime;
    private String notes;

    public Notice() {
    }

    public Notice(int id, String title, String content, Date pubdatetime, String notes) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubdatetime = pubdatetime;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubdatetime() {
        return pubdatetime;
    }

    public void setPubdatetime(Date pubdatetime) {
        this.pubdatetime = pubdatetime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubdatetime=" + pubdatetime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
