<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/helpers/authCheck.jsp"/>
<html>
<head>
    <title>cluttr | friend requests</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <%
        List<User> requests = FriendsHelper.getFriendRequests((Long)session.getAttribute("user"));
        if (requests.size() == 0) {
            %> you have no friend requests <%
        } else {
            %>
            <table class="table find-friends-table">
                <%
                    for (User user : requests) {
                %>
                <tr>
                    <td>
                        <a href="user?id=<%=user.getUserId()%>"><%=user.getUsername()%></a>
                    </td>
                    <td>
                        <jsp:include page="/forms/acceptFriendForm.jsp">
                            <jsp:param name="requestor" value="<%=user.getUserId()%>"/>
                        </jsp:include>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
        }
    %>
</div>
</body>
</html>
