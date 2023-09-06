<%-- 
    Document   : operation
    Created on : Sep 6, 2023, 7:17:54 AM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sum</title>
    </head>
    <body>
        <% int a = Integer.parseInt(request.getParameter("n1"));
            int b = Integer.parseInt(request.getParameter("n2")) ;
//            int sum  = a + b ;
        %>
        <h2>The result is : <%= a / b %></h2>
    </body>
</html>
