package com.tech.blog.dao;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PostDao {
    public ArrayList getCategory(Connection conn) throws SQLException
    {
        ArrayList<Category> categories = new ArrayList<>() ;
        try{
            String query = "select * from category";
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(query) ;
            while(resultSet.next())
            {   
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                String Description = resultSet.getString("Description");
                Category category = new Category(Id,Name,Description) ;
                categories.add(category) ;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return categories ;
    }
    
    public boolean savePost(Connection conn, Post post) throws SQLException
    {   
        boolean save = false ;
        try
        {
            String query = "insert into post(Title,Content,Code,Cid,UserId,Image) values(?,?,?,?,?,?) " ;
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getContent());
            stmt.setString(3, post.getCode());
            stmt.setInt(4, post.getCid());
            stmt.setInt(5, post.getUserId());
            stmt.setString(6, post.getImage());
            
            stmt.executeUpdate() ;
            save = true ;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return save ;
    }
}
