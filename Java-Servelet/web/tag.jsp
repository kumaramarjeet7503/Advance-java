<%-- 
    Document   : tag
    Created on : Sep 6, 2023, 9:20:25 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tag-lib" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <t:tag1 number="23"></t:tag1>
         Changes <% response.sendRedirect("test.jsp");             %>
    </body>
</html>
