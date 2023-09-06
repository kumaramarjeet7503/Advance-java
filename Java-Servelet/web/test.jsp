<%-- 
    Document   : test
    Created on : Sep 5, 2023, 11:19:42 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file ="header.jsp" %>
        <h1>Hello World!</h1>
        <%! String name = "Amarjeet Kumar" ;%>
        <p>My name is <%= name%></p>
        <p>Today's Date is <%= new Date().toString() %></p>
        <p>Division <% int a = 25/0 ; %> </p>
    </body>
</html>
