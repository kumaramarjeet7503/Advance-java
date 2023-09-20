<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%
    PostDao postDao = new PostDao();
    List<Post> postLists = postDao.getAllPosts(ConnectionProvider.getConnection()) ;   
%>

<div class="row">
    <% for(Post post : postLists){ %>
    <div class="col-md-6">
        <div class="card">
            <div class="card-body">
                <img  class="card-img-top" src="post/<%= post.getImage() %>"></img>
                <h4><%= post.getTitle() %></h4>
                <p><%= post.getContent() %></p>
            </div>
        </div>
    </div>
    <% }%>
</div>