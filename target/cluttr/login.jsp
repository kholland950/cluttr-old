<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 11/20/15
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cluttr | login</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
    <div class="container">
        <jsp:include page="/header.jsp"/>
        <h3>login</h3>
        <div class="col-lg-4">
            <form action="/login" method="post">
                <div class="form-group">
                    <jsp:include page="/helpers/usernameInput.jsp"/>
                </div>
                <jsp:include page="/helpers/errorMessage.jsp"/>
                <p>dont have an account? sign up <a href="signup.jsp">here</a> </p>
                <button type="submit" class="btn btn-default">login</button>
            </form>
        </div>
    </div>
</body>
</html>
