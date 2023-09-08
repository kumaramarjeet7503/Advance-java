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
        <title>Home</title>
    </head>
    <body>
        <%@include file="navbar.jsp"  %>
        <div class="container-fluid p-0">
             <div class="jumbotron bg-primary banner-background text-white">
            <div class="container">
                <h1 class="display-3" >Welcome to Techblog</h1>
                <p>We are here for the help</p>
                <button class="btn btn-outline-light btn-lg" >Get Started!</button>
                <button class="btn btn-outline-light btn-lg" ><span class="fa fa-user pr-1"></span>Login</button>
            </div>
            </div>
            
        </div>
        
           <div class="container">
               <div class="row mb-2">
                   <div class="col-md-4">
                       <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
                   <div class="col-md-4">
                        <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
                   <div class="col-md-4">
                        <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
               </div>
               
                              <div class="row">
                   <div class="col-md-4">
                       <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
                   <div class="col-md-4">
                        <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
                   <div class="col-md-4">
                        <div class="card" style="">
                            <img class="card-img-top" src="..." alt="Card image cap">
                            <div class="card-body">
                              <h5 class="card-title">Card title</h5>
                              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                              <a href="#" class="btn btn-primary">Go somewhere</a>
                            </div>
                          </div>
                   </div>
               </div>
           </div>
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/site.js"></script>
    </body>
</html>
