<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/helpers/authCheck.jsp"/>
<%
    Long userLoggedIn = (Long)session.getAttribute("user");
    Long userId = Long.parseLong(request.getParameter("id"));
    boolean isMe = userId == session.getAttribute("user");
%>
<html>
<head>
    <title>cluttr | friends</title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <h2><% if (isMe) { %>your <% } else { %><%=UserUtil.getUsername(userId)%>'s <% } %> friends</h2>
    <table class="table find-friends-table">
        <%
        int limit = 15;
        int i = 0;
        List<User> friends = FriendsHelper.getAllFriends(userId);
        if (friends.size() == 0) { %>
            <h5>you have no friends yet.</h5>
            <p>find friends <a href="findFriends.jsp">here</a>.</p>
        <% }
        for (User user : friends) {
            if (user.getUserId().equals(userLoggedIn)) continue;
        %>
            <tr>
                <td>
                    <a href="user?id=<%=user.getUserId()%>"><%=user.getUsername()%></a>
                </td>
                <td>
                    <% if (isMe) { //if looking at my friends, can delete them %>
                        <jsp:include page="/forms/deleteFriendForm.jsp">
                            <jsp:param name="target" value="<%=user.getUserId()%>"/>
                        </jsp:include>
                    <% //if friends
                      } else if (FriendsHelper.areFriends(user.getUserId(), userLoggedIn)) { %>
                        <jsp:include page="/helpers/friendLabel.jsp"/>
                    <% } else { //not friends, request button %>
                        <jsp:include page="/forms/friendRequestForm.jsp">
                            <jsp:param name="target" value="<%=user.getUserId()%>"/>
                        </jsp:include>
                    <% } %>
                </td>
            </tr>
        <%
            if (i == limit) break;
            i++;
        }
        %>
    </table>
</div>
</body>
</html>
