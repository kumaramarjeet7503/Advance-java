package com.tech.blog.entities;

import java.sql.Timestamp;

public class Category {
    private int Id ;
    private String Description ;
    private String Name ;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    private Timestamp CreatedAt ;
    
    public Category(int Id, String Name ,String Description)
    {
        this.Id = Id ;
        this.Name = Name ;
        this.Description = Description ;
    }

    public Category( String Name, String Description)
    {
        this.Name = Name ;
        this.Description = Description ;
    }
    
    public Category( )
    {
       
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
