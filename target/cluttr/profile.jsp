<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%@ page import="edu.capital.csdb.models.User" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/helpers/authCheck.jsp"/>
<%
    Long userId;
    Long meId = (Long)session.getAttribute("user");
    String username;
    boolean isMe = true;
    if (request.getParameter("id") != null) {
        userId = Long.parseLong(request.getParameter("id"));
        isMe = userId.equals(meId);
    } else {
        userId = (Long)session.getAttribute("user");
    }
    username = UserUtil.getUsername(userId);

    boolean areFriends = true;
    if (!isMe) {
        areFriends = FriendsHelper.areFriends(userId, (Long)session.getAttribute("user"));
    }
%>
<html>
<head>
    <title>cluttr | <%=username%></title>
    <jsp:include page="/head.jsp"/>
</head>
<body>
<div class="container">
    <jsp:include page="/header.jsp"/>
    <div class="row row-height">
        <h3 class="profile-header">
            <% if (isMe) { %>your<% } else { %><%=username%>'s<% } %> profile</h3>
        <%
            Long userLoggedIn = (Long)session.getAttribute("user");
            if (!userLoggedIn.equals(userId)) {
                %>
                <div class="col-md-4">
                    <div class="friends-label">
                        <% if (FriendsHelper.friendRequestExists(userId, userLoggedIn)) { %>
                            <jsp:include page="/forms/acceptFriendForm.jsp">
                                <jsp:param name="requestor" value="<%=userId%>"/>
                            </jsp:include>
                        <% } else if (!FriendsHelper.areFriends(userLoggedIn, userId)) {
                            if (FriendsHelper.friendRequestExists(userLoggedIn, userId)) { %>
                                <jsp:include page="/helpers/requestSent.jsp"/>
                            <% } else { %>
                                <jsp:include page="/forms/friendRequestForm.jsp">
                                    <jsp:param name="target" value="<%=userId%>"/>
                                </jsp:include>
                            <% } %>
                        <% } else if (FriendsHelper.areFriends(userLoggedIn, userId)) { %>
                            <jsp:include page="/helpers/friendLabel.jsp"/>
                        <% } %>
                    </div>
                </div>
            <% } %>

    </div>
    <div class="row">
        <div class="col-md-8">
            <h3>posts</h3>
            <% if (!areFriends) { %>
                you must be friends to view this user's posts
            <% } else { %>
                <jsp:include page="/helpers/postView.jsp">
                    <jsp:param name="userId" value="<%=userId%>"/>
                </jsp:include>
            <% } %>
        </div>
        <div class="col-md-3">
            <h3>friends</h3>
            <% List<User> friends = FriendsHelper.getAllFriends(userId); %>

            <%
                if (isMe) {
            %>
            you have
            <%
            } else {
            %>
            <%=username%> has
            <%
                }
            %>

            <% if (friends.size() == 0) { %>
            no friends yet.
            <p>find friends <a href="findFriends.jsp">here</a>.</p>
            <% } else { %>
            <%=friends.size()%> friends.
            <hr/>
            <table class="find-friends-table">
                <%
                    int limit = 15;
                    int i = 0;
                    for (User user : friends) {
                %>
                <tr>
                    <td>
                        <a href="user?id=<%=user.getUserId()%>"><%=user.getUsername()%></a>
                    </td>
                </tr>
                <%
                        if (i == limit) break;
                        i++;
                    }
                %>
            </table>
            <hr/>
            <a href="friends.jsp?id=<%=userId%>">see all friends</a>
            <%
                }
            %>
        </div>
    </div>
</div>

</body>
</html>
