<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%@ page import="edu.capital.csdb.models.dataUtil.FriendsHelper" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 11/20/15
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <header>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="/" class="navbar-brand">cluttr</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <%if (session.getAttribute("user") == null) { %>
                            <li>
                                <a href="login.jsp">login</a>
                            </li>
                            <li>
                                <a href="signup.jsp">signup</a>
                            </li>
                        <% } else {%>
                        <li>
                            <%  int n = FriendsHelper.getFriendRequests((Long)session.getAttribute("user")).size();
                                if (n == 1) {
                                    %><a href="friendRequests.jsp"><b>1 friend request</b></a><%
                                } else if (n > 1){
                                    %><a href="friendRequests.jsp"><b><%=n%> friend requests</b></a><%
                                }
                            %>
                        </li>
                        <li><a href="/findFriends.jsp">find friends</a></li>
                        <li>
                            <div class="dropdown btn navbar-btn">
                                <a href="#" data-toggle="dropdown" class="dropdown-link">
                                    hello, <%=UserUtil.getUsername((Long)session.getAttribute("user"))%>
                                    <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="profile.jsp">profile</a></li>
                                    <li><a href="logout">log out</a></li>
                                </ul>
                            </div>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <jsp:include page="helpers/successMessage.jsp"/>
</body>
</html>
