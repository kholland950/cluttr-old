<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/acceptFriend" method="post">
  <input type="hidden" name="requestor" value="${param.requestor}"/>
  <input type="hidden" name="target" value="<%=(Long)session.getAttribute("user")%>"/>
  <button class="btn" type="submit">accept friend request</button>
</form>
