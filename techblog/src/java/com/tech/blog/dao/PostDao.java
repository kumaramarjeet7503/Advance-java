package com.tech.blog.dao;

import com.tech.blog.entities.Category;
import java.sql.Connection;
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
}
