<%-- 
    Document   : login
    Created on : Sep 9, 2023, 12:25:16 AM
    Author     : amarj
--%>

<%@page import="com.tech.blog.entities.Message"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/site.css"/>
        <style>
            .banner-background
            {
                clip-path: polygon(50% 0%, 100% 0, 100% 85%, 0 100%, 0 0);
            }
        </style>
        <title>Login</title>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <main class="d-flex align-items-center banner-background bg-primary" style="height : 70vh;">
            <div class="container col-md-5 offset-5" >
            <div class="row" >
                <div class="card ">
                    <div class="card-header text-center bg-primary">
                        <h2>Login</h2>
                    </div>
                    <%    Message msg = (Message) session.getAttribute("msg") ; if(msg != null){   %>
                    <div class="alert alert-danger" role="alert">
                        <%= msg.getContent() %>
                      </div>
                    <% session.removeAttribute("msg") ; } %>
                    <div class="card-body">
                        <form action="login" method="post">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="email" name="userEmail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="userPassword" class="form-control" id="exampleInputPassword1" placeholder="Password">
                      </div>
                        <div class="text-center">
                      <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                    </div>
               </div>     
            </div>
         </div>
        </main>
        
         <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
