package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
    private int Id ;
    private String Title ;
    private String Content ;
    private String Code ;
    private Timestamp CreatedDate ;
    private int Cid ;

    public Post(int Id, String Title, String Content, String Code, int Cid) {
        this.Id = Id;
        this.Title = Title;
        this.Content = Content;
        this.Code = Code;
        this.Cid = Cid;
    }

    public Post(String Title, String Content, String Code, int Cid) {
        this.Title = Title;
        this.Content = Content;
        this.Code = Code;
        this.Cid = Cid;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public Timestamp getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Timestamp CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public int getCid() {
        return Cid;
    }

    public void setCid(int Cid) {
        this.Cid = Cid;
    }
    

}
