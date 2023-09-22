package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QueryDao {
 
        public static boolean executeInsert(String query, String[] values, Connection conn)
    {
        boolean executed = false ;
                try
        {
            PreparedStatement stmt = conn.prepareStatement(query);
            for(int i = 1; i <= values.length ; i++){
                stmt.setString(i, values[i]);
            }
            stmt.executeUpdate() ;
            executed = true ;
            
        }
        catch(Exception e)
        {
        }
        return executed ;
    }
    
        public static ResultSet executeSelect(String query, String[] values, Connection conn)
    {
          ResultSet   result  = null ;
        try
        {
            PreparedStatement stmt = conn.prepareStatement(query);
            for(int i = 1; i <= values.length ; i++){
                stmt.setString(i, values[i]);
            }
             result = stmt.executeQuery() ;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result ;
    }
    
}
