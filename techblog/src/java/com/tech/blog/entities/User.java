package com.tech.blog.entities;
import java.sql.* ;
public class User {
    private String Name ;
    private String Email ;
    private String Password ;
    private Timestamp CreatedAt ;
    private String UserId ;
    
        public User(String name, String  email, String password, Timestamp createdAt)
        {
            this.Name = name ;
            this.Email = email ;
            this.Password = password ;
            this.CreatedAt = createdAt ;
        }

        public User()
        {

        }
    
        public void setName(String name)
        {
             this.Name = name ;
        }
        public String getName()
        {
            return Name ;
        }

        public void setEmail(String email)
        {
            this.Email = email ;
        }
        public String getEmail()
        {
            return Email ;
        }  
        public void setPassword(String password)
        {
            this.Password = password ;
        }
            public String getPassword()
        {
            return Password ;
        }  
        public void setCreatedAt(Timestamp createdAt)
        {
             this.CreatedAt = createdAt ;
        }
        public Timestamp getCreatedAt()
        {
            return CreatedAt ;
        }
        
        public String getUserId()
        {
            return UserId ;
        }
            
        public void setUserId(String userId)
        {
             this.UserId = userId ;
        }
    
    }
