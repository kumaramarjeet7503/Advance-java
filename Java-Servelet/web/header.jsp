<%-- 
    Document   : header
    Created on : Sep 5, 2023, 11:30:06 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
    </head>
    <body >
        <div class="row col-md-12" style="background: red; margin: auto">
            <c:set var="head" value="Header" ></c:set>
            <h1><c:out value= "${head}" ></c:out></h1>
        </div>
    </body>
</html>
