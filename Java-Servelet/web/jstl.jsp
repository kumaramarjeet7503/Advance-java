<%-- 
    Document   : jstl
    Created on : Sep 7, 2023, 11:44:16 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sq" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <!--Jstl set--> 
        <c:set var="i" value="12" ></c:set>
        <c:set var="k" value="10"></c:set>
         <c:set var="m" value="Amarjeet"></c:set>
        <!--Jstl out-->
        <c:out value="${i}"></c:out>
        <c:remove var="i"></c:remove>
        <!--Conditional tag in jstl-->
        <c:if var="k" test="${k == 1}" >
            <h2>Successfull enter jstl and used if tag </h2>
        </c:if>
            <!--Jstl function tag-->
        <c:out value="${fn:length(m)}"></c:out>
        <!--Jstl looping tag-->
        <c:forEach var="p" begin="1" end="1" >
            <h1> The selected number is <c:out value="${p}"></c:out> </h1>
        </c:forEach>
            <!--Jstl redirect tag-->
        <%--<c:redirect url="https:www.google.com"></c:redirect>--%>
        <sq:setDataSource driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/java" user="root" password="" var="ds"></sq:setDataSource>
        <sq:query dataSource="${ds}" var = "rs">select * from user</sq:query>
        <div class="container">
        <table class="table">
            <tr>
                <td>UserId</td>
                <td>Email</td>
                <td>Password</td>
                <td>CreatedAt</td>
            </tr>
        <c:forEach var="row" items="${rs.rows}" >
            <tr>
                <td><c:out value="${row.UserId}"></c:out></td>
                <td><c:out value="${row.Email}"></c:out></td>
                <td><c:out value="${row.Password}"></c:out></td>
                <td><c:out value="${row.CreatedAt}"></c:out></td>
            </tr>
        </c:forEach>
        </table> 
        </div>   
    </body>
</html>
