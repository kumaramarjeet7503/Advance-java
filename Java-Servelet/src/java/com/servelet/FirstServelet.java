package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.* ;

public class FirstServelet implements Servlet {
    
    ServletConfig config ;
    // Overriding servlet functions
  
    @Override
     public void init(ServletConfig config) throws ServletException
     {
         System.out.println("The servelet request has been started");
     }

     @Override
    public ServletConfig getServletConfig()
    {
        return this.config ;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        System.out.println("We are in the service class");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter() ;
        out.println("This is printer") ;
    }

    @Override
    public String getServletInfo()
    {
        return "we are getting servelet information" ;
    }

    @Override
    public void destroy()
    {   
        System.out.println("The servlet request has been destroyed");
    }
}
