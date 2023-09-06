<%-- 
    Document   : operation
    Created on : Sep 6, 2023, 7:02:09 AM
    Author     : amarj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage= "error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Display</title>
    </head>
    <body>
        <form method="post" action="operation.jsp" >
        <div class="container">
            <div class=""row">
                <div class="col-md-6 offset-md-3">
                
                    <div class="card">
                        <div class="card-header bg-secondary text-white text-center">
                            <h2>Sum of two number</h2>
                        </div>
                        <div class="card-body">
                            <input name="n1" class="form-control form-group" type="number"></input>
                            <input name="n2" class="form-control form-group" type="number"></input>
                        </div>
                        <div class="card-footer text-right bg-secondary">
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </div>
                    
                </div>
                </div>
            </div>
            </form>
    </body>
</html>
