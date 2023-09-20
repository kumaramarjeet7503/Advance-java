package com.tech.blog.helper;

import java.sql.* ;
import java.sql.SQLException ;

public class ConnectionProvider {
    private static Connection conn ; 
    /*
    * Provide sql connection object to make query
    */
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
       
        try
        {
            if(conn == null){
                Class.forName("com.mysql.cj.jdbc.Driver") ;
                String url = "jdbc:mysql://localhost:3306/java" ;
                String user = "root";
                String password = "" ;
                // Connect mysql data base using driver manager         
                conn = DriverManager.getConnection(url,user,password) ;
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            
        }
        return conn ;
    
    }
    

}
