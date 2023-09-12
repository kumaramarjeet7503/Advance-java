<%-- 
    Document   : profile
    Created on : Sep 12, 2023, 7:14:42 AM
    Author     : amarj
--%>

<%@page import="com.tech.blog.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("currentUser");
            if(user == null) response.sendRedirect("signup.jsp"); 
        %>
        <h1>Your profile</h1>
        <h3>Email : <%= user.getEmail() %></h3>
    </body>
</html>
