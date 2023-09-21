<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%
    PostDao postDao = new PostDao();
    List<Post> postLists = new ArrayList<>() ;
    int cid = Integer.parseInt(request.getParameter("cid"))   ;
    if(cid == 0)
    {
       postLists = postDao.getAllPosts(ConnectionProvider.getConnection()) ; 
    }else 
    {
         postLists = postDao.getPostsByCategory(ConnectionProvider.getConnection(),cid) ;
    }
    ;   
%>

<div class="row">
    <% for(Post post : postLists){ %>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body" style="padding : 0px">
                <img  class="card-img-top" src="post/<%= post.getImage() %>" alt="Card image cap"></img>
                <h4><%= post.getTitle() %></h4>
                <p><%= post.getContent() %></p>
            </div>
            <div class="card-footer bg-primary text-left">
                <a href="#" class="btn btn-outline-light btn-sm " ><i class="fa fa-thumbs-up" ><span>10</span></i></a>
                <a href="#" class="btn btn-outline-light btn-sm"><i class="fa fa-comment" ><span>10</span></i></a>
                <a href="blog-post.jsp?pid=<%= post.getId() %>" class="btn btn-outline-light btn-sm" style="float : right">Read More</a>
            </div>
        </div>
    </div>
    <% }%>
</div>