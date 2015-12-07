<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 11/30/15
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cluttr | signup</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <h3>signup</h3>
    <div class="col-lg-3">
        <form action="/signup" method="post">
            <div class="form-group">
                <jsp:include page="/helpers/usernameInput.jsp"/>
            </div>
            <jsp:include page="/helpers/errorMessage.jsp"/>
            <button type="submit" class="btn btn-default">signup</button>
        </form>
    </div>
</div>
</body>
</html>
