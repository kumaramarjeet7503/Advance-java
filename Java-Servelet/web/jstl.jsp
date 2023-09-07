<%-- 
    Document   : jstl
    Created on : Sep 7, 2023, 11:44:16 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!--Jstl set--> 
        <c:set var="i" value="12" ></c:set>
        <c:set var="k" value="10"></c:set>
        <!--Jstl out-->
        <c:out value="${i}"></c:out>
        <c:remove var="i"></c:remove>
        <!--Conditional tag in jstl-->
        <c:if var="k" test="${k == 1}" >
            <h2>Successfull enter jstl and used if tag </h2>
        </c:if>
        <!--Jstl looping tag-->
        <c:forEach var="p" begin="1" end="10" >
            <h1> The selected number is <c:out value="${p}"></c:out> </h1>
        </c:forEach>
            <!--Jstl redirect tag-->
        <c:redirect url="https:www.google.com"></c:redirect>
    </body>
</html>
