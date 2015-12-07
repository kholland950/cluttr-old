<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.capital.csdb.models.Post" %>
<%@ page import="edu.capital.csdb.models.DAO.DAOFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>cluttr | home</title>
        <jsp:include page="head.jsp"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <% if (session.getAttribute("user") == null) { %>
                <h3>welcome to cluttr! <a href="${pageContext.request.contextPath}/login.jsp">login</a></h3>
            <% } else { %>
                <div class="row">
                    <div class="col-md-5">
                        <jsp:include page="forms/postForm.jsp"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 posts">
                        <jsp:include page="helpers/postView.jsp"/>
                    </div>
                </div>
            <% } %>
        </div>
    </body>
</html>
