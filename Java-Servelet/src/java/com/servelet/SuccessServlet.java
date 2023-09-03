package com.servelet;

import java.io.PrintWriter;
import javax.servlet.http.* ;
import javax.servlet.ServletException ;
import java.io.IOException ;

public class SuccessServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException
    {
           response.setContentType("text/html") ;
           PrintWriter out = response.getWriter() ;
           out.println("<h3>Welcome to Success Servlet. Sum : "+request.getAttribute("sum")+"</h3>");
    }
}
