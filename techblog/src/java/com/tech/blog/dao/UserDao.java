package com.tech.blog.dao;

import com.tech.blog.entities.* ;
import com.tech.blog.helper.* ;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

    public UserDao(Connection connect) {
    }
    private Connection conn ;
//    private User user ;
    
    public void UserDao(Connection connect) 
    {
         this.conn = connect ;
    }
    
    public  boolean saveUser(User user, Connection conn)
    {
        boolean flag = false ;

        try{  
            String query = "insert into user(Name,Password,Email) values(?,?,?)" ;
            PreparedStatement pstm = conn.prepareStatement(query) ;
            pstm.setString(1,user.getName());
             pstm.setString(2,user.getPassword());
              pstm.setString(3,user.getEmail());
//              pstm.setString(4,user.getCreatedAt());
              pstm.executeUpdate() ;
              flag = true ;
              
        }catch(SQLException e)
        { 
        }
        
        return flag ;
    }
    
    public User getUserByEmailAndPassword(String email, String password , Connection conn)
    {
        User user = null ;
        try{
            String query = "select * from user where Email = ? and Password = ?" ;
             PreparedStatement pstm = conn.prepareStatement(query) ;
             pstm.setString(1,email);
             pstm.setString(2,password);
             
             ResultSet set  = pstm.executeQuery() ;
             if(set.next())
             {
                 user = new User() ;
                 user.setName(set.getString("Name")) ;
                 user.setPassword(set.getString("Password")) ;
                 user.setEmail(set.getString("Email")) ;
                 user.setCreatedAt(set.getTimestamp("CreatedAt")) ;
                 user.setUserId(set.getString("UserId")) ;
                 user.setImageName(set.getString("Image"));
             }
             
        }catch(SQLException e)
        {
        }
        return user ;
    }
    
    public boolean updateUser(User user, Connection conn)
    {
        boolean flag =false ;
        
        try{
            String query = "update user set Name = ?, Password = ?, Image = ? where UserId = ? " ;
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3, user.getImageName());
            pstm.setString(4, user.getUserId());
            pstm.executeUpdate();
            flag = true ;
        }
        catch(SQLException e)
        {
            
        }
        
        return flag ;
    }
    
    public User getUserById(int userId) throws SQLException, ClassNotFoundException
    {
        User user = null ;
        String strUserId = Integer.toString(userId) ;
        String query = "select * from user where UserId =  " + strUserId ;
        String[] values =  {} ; 
          ResultSet set  = QueryDao.executeSelect(query, values, ConnectionProvider.getConnection()) ;
             if(set.next())
             {
                 user = new User() ;
                 user.setName(set.getString("Name")) ;
                 user.setPassword(set.getString("Password")) ;
                 user.setEmail(set.getString("Email")) ;
                 user.setCreatedAt(set.getTimestamp("CreatedAt")) ;
                 user.setUserId(set.getString("UserId")) ;
                 user.setImageName(set.getString("Image"));
             }
         
        return user ;
    }
}
