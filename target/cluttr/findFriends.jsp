<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/2/15
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/helpers/authCheck.jsp"/>
<html>
<head>
    <title>cluttr | find friends</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    users you aren't friends with:
    <table class="table find-friends-table">
        <%  List<User> users = FriendsHelper.getUsersNotRelatedTo((Long) session.getAttribute("user"));
            for (User user : users) {
        %>  <tr>
                <td>
                    <a href="user?id=<%=user.getUserId()%>"><%=user.getUsername()%></a>
                </td>
                <td>
                    <jsp:include page="/forms/friendRequestForm.jsp">
                        <jsp:param name="target" value="<%=user.getUserId()%>"/>
                    </jsp:include>
                </td>
            </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>
