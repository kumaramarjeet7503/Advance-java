/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servelet;

import javax.servlet.* ;
import javax.servlet.http.* ;
import java.io.IOException;
import java.io.PrintWriter ;
/**
 *
 * @author amarj
 */
public class RegisterServlet extends HttpServlet {
    
    @Override 
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException
    {
           response.setContentType("text/html") ;
           PrintWriter out = response.getWriter() ;
           out.println("<h3>Welcome to Register Servlet.</h3>");
           
           String name = request.getParameter("user-name");
           String email = request.getParameter("user-email");
           String password = request.getParameter("user-password");
           String gender = request.getParameter("user-gender");
           String course = request.getParameter("user-course");
           String terms = request.getParameter("user-terms");
           
           if(terms != null){
               out.println("<h5>Name : "+name+"</h5>");
               out.println("<h5>email : "+email+"</h5>");
               out.println("<h5>Password : "+password+"</h5>");
               out.println("<h5>Gender : "+gender+"</h5>");
               out.println("<h5>Course : "+course+"</h5>");
               out.println("<h5>Terms : "+terms+"</h5>");
                RequestDispatcher rd = request.getRequestDispatcher("success");
                rd.forward(request,response);
           }else
           {
                out.println("<h3>Please accept terms and conditions first </h3>");
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request,response);
           }
           
    }
    
}
