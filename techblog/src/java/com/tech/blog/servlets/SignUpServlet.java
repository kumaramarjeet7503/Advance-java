/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.servlets;

import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.IOException;
import java.io.PrintWriter ;
import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import java.sql.Timestamp;
import java.util.Date;
import com.tech.blog.helper.* ;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpServlet extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
    {
        try {
           response.setContentType("text/html") ;
           PrintWriter out = response.getWriter() ;
    
         
//           Take data from request 
           String name = request.getParameter("user-name");
           String email = request.getParameter("user-email");
           String password = request.getParameter("user-password");  
           Date date = new Date() ;
           Timestamp createdAt = new Timestamp(date.getTime()) ;
           User user = new User(name,email,password,createdAt) ;
        
           UserDao userDao = new UserDao(ConnectionProvider.getConnection()) ;
           boolean save = userDao.saveUser(user,ConnectionProvider.getConnection()) ;
                out.println(save);
           if(save )
            {
                out.println("Success");
            } 
        } catch (IOException e) {
        } catch (SQLException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
                     
    }
    
}
