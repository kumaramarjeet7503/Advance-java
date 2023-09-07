/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jdbc;

import java.sql.* ;
import java.sql.SQLException ;

/**
 *
 * @author amarj
 */
public class Connect {
    public static Connection conn ; 
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
        Class.forName("com.mysql.cj.jdbc.Driver") ;
        String url = "jdbc:mysql://127.0.0.1:3306/java" ;
        String user = "root";
        String password = "" ;
        
        // Connect mysql data base using driver manager         
        Connection conn = DriverManager.getConnection(url,user,password) ;
        return conn ;
    }
}
