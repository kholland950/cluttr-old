<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/requestFriend" method="post">
    <input type="hidden" name="requestor" value="<%=(Long)session.getAttribute("user")%>"/>
    <input type="hidden" name="target" value="${param.target}"/>
    <button class="btn" type="submit">send friend request</button>
</form>
