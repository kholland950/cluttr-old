<%@ page import="edu.capital.csdb.models.Post" %>
<%@ page import="edu.capital.csdb.models.DAO.DAOFactory" %>
<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/helpers/authCheck.jsp"/>
<%
    Post post = DAOFactory.getPostDAO().getPost(Long.parseLong(request.getParameter("id")));
    User user = DAOFactory.getUserDAO().getUser(post.getUserId());
%>
<html>
<head>
    <title>cluttr | <%=user.getUsername()%>'s post</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <div class="post-view col-md-8">
        <h4><a href="user?id=<%=user.getUserId()%>"><%=user.getUsername()%></a></h4>
        <div class="post-text"><%=post.getText()%></div>
        <jsp:include page="/helpers/postBanner.jsp">
            <jsp:param name="id" value="<%=post.getPostId()%>"/>
            <jsp:param name="postPage" value="yes"/>
        </jsp:include>
        <jsp:include page="/helpers/commentSection.jsp">
            <jsp:param name="postId" value="<%=post.getPostId()%>"/>
        </jsp:include>
        <jsp:include page="/forms/commentForm.jsp">
            <jsp:param name="postId" value="<%=post.getPostId()%>"/>
        </jsp:include>
    </div>
</div>
</body>
</html>
