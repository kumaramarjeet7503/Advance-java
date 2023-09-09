package com.tech.blog.dao;

import com.tech.blog.entities.* ;
import com.tech.blog.helper.* ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.* ;

public class UserDao {
    private Connection conn ;
    
    public Connection UserDao() throws SQLException, ClassNotFoundException
    {
        Connection conn = ConnectionProvider.getConnection() ;
        return conn ;
    }
    
    public boolean saveUser(User user)
    {
        boolean flag = false ;
        
        try{
            String query = "insert into user(Name,Password,Email,CreatedAt) values(?,?,?,?)" ;
            PreparedStatement pstm = conn.prepareStatement(query) ;
            pstm.setString(1,user.getName());
             pstm.setString(2,user.getPassword());
              pstm.setString(3,user.getEmail());
              pstm.setTimestamp(4,user.getCreatedAt());
              
        }catch(Exception e)
        { 
            e.printStackTrace() ;
        }
        
        return flag ;
    }
}
