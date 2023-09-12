/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.entities;

/**
 *
 * @author amarj
 */
public class Message {
    
    private String content ;
    private String type ;
    private String css ;
    
    public Message(String content,String type, String css )
    {
        this.content = content ;
        this.type = type ;
        this.css = css ;
    }
//    Getters and setters
    
    public  String getContent()
    {
        return this.content ;
    }
    
    public  String getType() 
    {
        return this.type ;
    }
    
    public  String getCss()
    {
        return this.css ;
    }
    
    public  void setContent(String content)
    {
        this.content = content ;
    }
    
    public  void setType(String type) 
    { 
         this.type = type ;
    }
    
    public  void setCss(String css)
    {
        this.css = css ;
    }
            
}
