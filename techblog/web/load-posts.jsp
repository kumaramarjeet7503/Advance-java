<%@page import="com.tech.blog.dao.LykeDao"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%
//     Get current user
     User currentUser = (User) session.getAttribute("currentUser");
     LykeDao dao = new LykeDao() ;
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
        <div class="card mb-2">
            <div class="card-body" style="padding : 0px">
                <img  class="card-img-top" style="height:262px" src="post/<%= post.getImage() %>" alt="Card image cap"></img>
                <h4><%= post.getTitle() %></h4>
                <div style="min-height: 100px; max-height: 100px; overflow: hidden">
                <p><%= post.getContent() %></p>
                </div>
            </div>
            <div class="card-footer bg-primary text-left">
                <a onclick="doLike(<%= post.getId()%>,<%= currentUser.getUserId() %>)" class="btn btn-outline-light btn-sm text-white " ><i class="fa fa-thumbs-up" ><span><%= dao.countLikeOnPost(post.getId(),Integer.parseInt(currentUser.getUserId())) %></span></i></a>
                <a href="#" class="btn btn-outline-light btn-sm"><i class="fa fa-comment" ><span>10</span></i></a>
                <a href="blog-post.jsp?pid=<%= post.getId() %>" class="btn btn-outline-light btn-sm" style="float : right">Read More</a>
            </div>
        </div>
    </div>
    <% }%>
</div>