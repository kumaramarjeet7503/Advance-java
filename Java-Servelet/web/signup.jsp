<%-- 
    Document   : signup
    Created on : Sep 3, 2023, 4:42:04 PM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <title>Signup</title>        
    </head>
    <body style="background : url(image/bg.jpg); background-size: cover ;">
        
        <div class="container ">
            <div class="row">
            <div class="col m6 offset-m3"> 
            <div class="card ">
                     <div class="card-content">
                         <form class="center-align" method="post" action="register" id="register-form">
                             <h3 style="margin-top :5px" class="text-center">SignUp</h3>
                             <p id="msg"></p>
                       
                            <div class="input-field ">
                              <input  id="user-name" name="user-name" type="text" class="validate">
                              <label class="active" for="user-name">Name</label>
                            </div>
                            <div class="input-field ">
                              <input  id="user-email" name="user-email" type="email" class="validate">
                              <label class="active" for="user-email">Email</label>
                            </div>
                             <div class="input-field">
                              <input  id="user-password" name="user-password" type="password" class="validate">
                              <label class="active" for="user-password">Password</label>
                            </div>
                             <button class="btn waves-effect waves-light" >SignUp</button>
                        </form>
                         
                         <div class="loader center-align" style="margin-top: 10px; display: none" id="loader">
                            <div class="preloader-wrapper big active ">
                                <div class="spinner-layer spinner-blue">
                                  <div class="circle-clipper left">
                                    <div class="circle"></div>
                                  </div><div class="gap-patch">
                                    <div class="circle"></div>
                                  </div><div class="circle-clipper right">
                                    <div class="circle"></div>
                                  </div>
                                </div>
                            </div>
                             <h3>Please wait...</h3>
                            </div>
                    </div>       
            </div>
            </div>
             </div>      
        </div>
        
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script>
            $("#register-form").on('submit',function(event){
                event.preventDefault();
                $("#register-form").hide();
                $("#loader").show() ;
               
               var f = $(this).serialize() ;
               $.ajax({
                   url:"register",
                   data:f,
                   type:'POST',
                   success:function(response)
                   {
                        $("#register-form").show();
                        $("#loader").hide() ;
                        $("#msg").text("Registration Completed");
                        $("#msg").css("color","green");
                   },
                   error:function(error)
                   {
                       sleep(3000);
                       console.log(error);
                        $("#register-form").show();
                        $("#loader").hide() ;
                        $("#msg").text("Failure! Please try again.");
                        $("#msg").css("color","red");
                   }
               });
            });
        </script>
    </body>
</html>
