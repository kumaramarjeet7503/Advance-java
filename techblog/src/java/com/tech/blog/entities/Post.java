package com.tech.blog.entities;

import java.sql.Timestamp;

public class Post {
    private int Id ;
    private String Title ;
    private String Content ;
    private String Code ;
    private Timestamp CreatedDate ;
    private int Cid ;
    private int UserId ;
    private String Image ;

    public Post(int Id, String Title, String Content, String Code, int Cid, int UserId, String Image) {
        this.Id = Id;
        this.Title = Title;
        this.Content = Content;
        this.Code = Code;
        this.Cid = Cid;
        this.UserId = UserId ;
        this.Image = Image ;
    }

    public Post(String Title, String Content, String Code, int Cid, int UserId, String Image) {
        this.Title = Title;
        this.Content = Content;
        this.Code = Code;
        this.Cid = Cid;
        this.UserId = UserId ;
        this.Image = Image ;
    }
        public Post() {
       
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

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    

}
