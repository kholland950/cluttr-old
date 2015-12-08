<%@ page import="edu.capital.csdb.models.dataUtil.LikeUtil" %>
<%@ page import="edu.capital.csdb.models.Post" %>
<%@ page import="edu.capital.csdb.models.DAO.DAOFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post post = DAOFactory.getPostDAO().getPost(Long.parseLong(request.getParameter("id")));
    boolean postPage = false;
    if (request.getParameter("postPage") != null) {
        postPage = true;
    }
%>
<div class="post-banner">
    <h5>
        <span id="num-likes<%=post.getPostId()%>">
            <% if (post.likes.size() == 0) { %>
                no likes
            <% } else if (post.likes.size() == 1) { %>
                1 like
            <% } else { %>
                <%=post.likes.size()%> likes
            <% } %>
        </span>
         |
        <span id="num-comments<%=post.getPostId()%>">
            <% if (post.comments.size() == 0)  { %>
                no comments
            <% } else if (post.comments.size() == 1) { %>
                1 comment
            <% } else { %>
                <%=post.comments.size()%> comments
            <% } %>
        </span>
    </h5>

    <%
        boolean liked = LikeUtil.userLikesPost((Long) session.getAttribute("user"), post.getPostId());
        if (!liked) { %>
        <button id="like<%=post.getPostId()%>" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-thumbs-up"></span> like
        </button>
    <% } %>

    <div class="liked-label" id="liked<%=post.getPostId()%>" <% if (!liked) { %> hidden <% } %>>
        <h5 style="float: left">liked</h5>
        <span class="ok glyphicon glyphicon-ok" style="color:#229933;"></span>
    </div>

    <% if (!postPage) { %>
        <a href="../showPost.jsp?id=<%=post.getPostId()%>&comment=true" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-comment"></span> comment
        </a>
        <a href="../showPost.jsp?id=<%=post.getPostId()%>" class="btn btn-sm btn-primary">
            <span class="glyphicon glyphicon-share-alt"></span> go to post
        </a>
    <% } %>
</div>

<script>
    if (likeButtons == undefined) {
        var likeButtons = [];
    }
    likeButtons[<%=post.getPostId()%>] = $("#like<%=post.getPostId()%>");
    likeButtons[<%=post.getPostId()%>].click(function() {
        $.ajax({
            url: 'like',
            data: {
                user: '<%=session.getAttribute("user")%>',
                post: '<%=post.getPostId()%>'
            },
            error: function() {
                $('#info').html('<p>An error has occurred</p>');
            },
            success: function(data) {
                likeButtons[<%=post.getPostId()%>].hide();
                $("#liked<%=post.getPostId()%>").show();
                $("#num-likes<%=post.getPostId()%>").text("<%=post.likes.size()+1%> like<%if (post.likes.size()>=1){%>s<%}%>");
            },
            type: 'POST'
        });
    });
</script>
