<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%@ page import="edu.capital.csdb.models.Post" %>
<%@ page import="edu.capital.csdb.models.DAO.DAOFactory" %>
<%@ page import="edu.capital.csdb.models.dataUtil.LikeUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post post = DAOFactory.getPostDAO().getPost(Long.parseLong(request.getParameter("id")));
%>
<div class="post">
    <a href="user?id=<%=post.getUserId()%>"><%=UserUtil.getUsername(post.getUserId())%></a>
    <div id="post-text<%=post.getPostId()%>" class="post-text preview"><%=post.getText()%></div>
    <span id="overflow<%=post.getPostId()%>" class="overflow glyphicon glyphicon-option-horizontal hidden"></span>

    <jsp:include page="postBanner.jsp">
        <jsp:param name="id" value="<%=post.getPostId()%>"/>
    </jsp:include>
</div>

<script>
    var postText = $("#post-text<%=post.getPostId()%>");
    if (postText[0].offsetHeight < postText[0].scrollHeight) {
        $("#overflow<%=post.getPostId()%>").removeClass("hidden");
    }
</script>
