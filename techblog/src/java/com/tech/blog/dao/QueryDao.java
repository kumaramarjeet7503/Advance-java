/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author amarj
 */
public class QueryDao {
 
        private boolean executeInsert(String query, String[] values, Connection conn)
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
