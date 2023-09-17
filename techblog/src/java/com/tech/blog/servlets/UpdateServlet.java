/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tech.blog.entities.User ;
import com.tech.blog.dao.UserDao ;
import com.tech.blog.entities.Message;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.FileHelper;
import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.InputStream  ;
import javax.servlet.http.HttpSession;
/**
 *
 * @author amarj
 */
@MultipartConfig
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

           String name = request.getParameter("update-user-name");
           String email = request.getParameter("update-user-email");
           String password = request.getParameter("update-user-password");  
           String userId = request.getParameter("user-id") ;
           
           HttpSession session = request.getSession() ;
           User currentUser = (User) session.getAttribute("currentUser") ;
           
            Part part = request.getPart("user-photo") ;
            String fileName = part.getSubmittedFileName() ;
                   
           Date date = new Date() ;
           Timestamp createdAt = new Timestamp(date.getTime()) ;
           User user = new User(name,email,password,createdAt) ;
           user.setUserId(userId);
           user.setImageName(fileName) ;
           
           UserDao userDao = new UserDao(ConnectionProvider.getConnection());
           boolean update = userDao.updateUser(user,ConnectionProvider.getConnection());
           
           if(update)
           {
               if(currentUser.getImageName() != null)
               {
                   String oldPath = request.getRealPath("/")+"pics"+File.separator+currentUser.getImageName() ;
                   FileHelper.deleteFile(oldPath) ;
               }
               String path = request.getRealPath("/")+"pics"+File.separator+user.getImageName() ;   
               boolean uploaded = FileHelper.uploadFile(part.getInputStream(), path);
                
               Message msg = new Message("Profile Updated successfully","success","alert-success");
               session.setAttribute("msg",msg);
           }
           response.sendRedirect("profile.jsp");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
