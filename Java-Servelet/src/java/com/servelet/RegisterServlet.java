/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servelet;

import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.IOException;
import java.io.PrintWriter ;
import com.tech.blog.helper.Connect;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.* ;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import javax.servlet.annotation.MultipartConfig;
/**
 *
 * @author amarj
 */
 @MultipartConfig
public class RegisterServlet extends HttpServlet {
    
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
           response.setContentType("text/html") ;
           PrintWriter out = response.getWriter() ;
           
           String name = request.getParameter("user-name");
           String email = request.getParameter("user-email");
           String password = request.getParameter("user-password");   
           Part part = request.getPart("user-image");
           String fileName = part.getSubmittedFileName() ;
           /*
           For Request Dispatcher
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
           For Sending attribute
            int sum = 10 ;
            Set Request Attribute
            request.setAttribute("sum",sum) ; 
           */
            
            // Set Registration into database
            Connection connect = null ;
                try {
                    connect = Connect.getConnection();
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
        try {
            if(connect.isClosed())
            {
                out.println("Failed");
            }else
            {
                // For getting local data and other records to insert
                InputStream is = part.getInputStream() ;
                byte[] byteFile =  new byte[is.available()] ;
                is.read(byteFile);
                
                String filePath = request.getRealPath("/")+"image"+File.separator+fileName ;
                out.println(filePath) ;
//                FileOutputStream fos = new FileOutputStream(filePath) ;
//                fos.write(byteFile) ;
//                fos.close();
                
//                 For uploading file in java
                 LocalDate currentDate = LocalDate.now();
                 
                String query = "insert into user (Name,Email,Password,CreatedAt) values(?,?,?,?)" ;
                PreparedStatement pd = connect.prepareStatement(query);
               
//                Set Dynamic data into query
                pd.setString(1,name);
                pd.setString(2,email);
                pd.setString(3,password);
                pd.setString(4, currentDate.toString());

//                pd.executeUpdate() ;
                connect.close();
                 out.println("success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
                     
    }
    
}
