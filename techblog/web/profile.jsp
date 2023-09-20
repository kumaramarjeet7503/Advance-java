<%@page import="com.tech.blog.entities.Category"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%
            User user = (User) session.getAttribute("currentUser");
            if(user == null || session == null)
            { 
                response.sendRedirect("login.jsp");
            } 

            PostDao postDao = new PostDao() ;
            ArrayList<Category> categories = postDao.getCategory(ConnectionProvider.getConnection()) ;
                                       
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/site.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>profile</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="index.jsp">Tech Blog</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="#">Learn <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Contact</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Courses
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Java</a>
                    <a class="dropdown-item" href="#">PHP</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Data Structures & Algorithm</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#"  data-toggle="modal" data-target="#postModal" ><i class="fa fa-vcard p-1"></i>Post</a>
                </li>
              </ul>
                
                  <ul class="navbar-nav mr-right">
                    <li class="nav-item">
                        <a class="nav-link" href="#!" data-toggle="modal" data-target="#profileModal"> <span class="fa fa-user-circle "></span> <%= user.getName()%> </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="logout"> <span class="fa fa-sign-out "></span> Logout</a>
                    </li>
                </ul>
            </div>
          </nav>

                    <%    Message msg = (Message) session.getAttribute("msg") ; if(msg != null){   %>
                    <div class="alert <%= msg.getClass() %>" role="alert">
                        <%= msg.getContent() %>
                      </div>
                    <% session.removeAttribute("msg") ; } %>
                    
                    <main>
                        <div class="container">
                            <div class="row mt-2">
                                <div class="col-md-4">   
                                    
                                    <div class="list-group">
                                        <a href="#" class="list-group-item list-group-item-action active">All Posts</a>
                                         <% for(Category cat : categories){ %>
                                        <a onclick="getPosts(<%= cat.getId() %>)" class="list-group-item list-group-item-action"><%= cat.getName() %></a>
                                        <% }%>
                                      </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="container text-center" id="post-container">
                                        <div id="loader">
                                            <div class="fa fa-refresh fa-4x fa-spin"></div>
                                            <h3 class="mt-2">Loading... </h3>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </main>

                <!-- Profile  Modal -->
                <div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="profileModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header bg-primary">
                        <h5 class="modal-title text-white" id="profileModalLabel">Profile Overview</h5>
                        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                          <div class="container text-center">
                              <img src="pics/<%= user.getImageName()%>" class="img-fluid" style="border-radius:50%;max-width: 150px;;"  >
                              <h3><%= user.getName() %></h3>

                              <div id="profile-overview">
                              <table class="table text-left">
                                <tbody>
                                        <tr>
                                    <th scope="row">Customer Id</th>
                                    <td><%=user.getUserId()%></td>

                                  </tr>
                                  <tr>
                                    <th scope="row">Email</th>
                                    <td><%=user.getEmail()%></td>

                                  </tr>
                                  <tr>
                                    <th scope="row">Registered On</th>
                                    <td><%=user.getCreatedAt()%></td>
                                  </tr>

                                </tbody>
                              </table>
                    </div>

                    <div id="profile-edit" style="display : none">
                           <label  id="edit-profile">Edit the form carefully</label>
                           <form action="update" method="POST" enctype="multipart/form-data" >
                                <table class="table text-left">
                                 <tbody>
                                         <tr>
                                     <th scope="row">Customer Id</th>
                                     <td><input class="form-control" name="user-id" type="text" value=<%=user.getUserId()%> readonly ></td>

                                   </tr>
                                   <tr>
                                     <th scope="row">Name</th>
                                     <td><input class="form-control" name ="update-user-name" type="text" value=<%=user.getName()%> ></td>
                                   </tr>
                                   <tr>
                                     <th scope="row">Email</th>
                                     <td><input class="form-control" name ="update-user-email" type="text" value=<%=user.getEmail()%> ></td>
                                   </tr>
                                    <tr>
                                     <th scope="row">Photo</th>
                                     <td> <input type="file" class="form-control-file" name="user-photo"></td>
                                   </tr>
                                   <tr>
                                     <th scope="row">Password</th>
                                     <td> <input type="text" name ="update-user-password"  value=<%=user.getPassword()%>  class="form-control" ></td>
                                   </tr>
                                   <tr>
                                     <th scope="row">Registered On</th>
                                     <td><input class="form-control"  type="date" value=<%=user.getCreatedAt()%>></td>
                                   </tr>
                                       
                                 </tbody>
                               </table>
                                   <button class="btn btn-primary" type="submit" >Save</button>
                           </form>
                    </div>

                          </div>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" id="profile-toggle" class="btn btn-primary">Edit</button>
                      </div>
                    </div>
                  </div>
                </div>
                    
                <!--Post Modal-->     
                <div class="modal fade" id="postModal" tabindex="-1" role="dialog" aria-labelledby="postModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header bg-primary">
                        <h5 class="modal-title text-white" id="postModalLabel">Post</h5>
                        <button type="button" class="close text-white" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                             
                    <div class="container text-center">
                            <div class="alert alert-success" style="display : none" id="post-success" role="alert">Your post has successfully added</div>
                  
                        <div id="post-edit">
                            <label  id="post-profile" style="float: left;">Do post your article</label>
                            <form id="dopost"  action="dopost"  method="post" > 

                                   <select name="post-category" class="form-control form-group " >
                                       <option selected disabled>Please select a category</option>
                                       <% for(Category cat : categories){ %>
                                       <option value="<%= cat.getId()%>"><%= cat.getName() %></option>
                                       <% }%>
                                   </select>
                                    <input class="form-group form-control" name="post-title" type="text"  placeholder="Please enter the title" >
                                    <textarea  class=" form-group form-control" name ="post-content" type="textarea" rows="4" placeholder="Please enter the content"  ></textarea>
                                    <textarea  class="form-group form-control" name ="post-description"textarea" rows="4" placeholder="Please enter the description"  ></textarea>
                                    <input type="file" class="form-group form-control-file" name="post-photo">  
                                     <button type="submit" class="btn btn-primary">Post</button>
                               </form>
                        </div>
                    </div>
                      </div>
                    </div>
                  </div>
                </div>
                    
               
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="js/profile.js"></script>
    </body>
</html>



