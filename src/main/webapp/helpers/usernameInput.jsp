<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/2/15
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input class="form-control" name="username" placeholder="username"
    <% if (session.getAttribute("username") != null) { %>
       value="<%=session.getAttribute("username")%>"
    <%}%>>
<% session.removeAttribute("username"); %>
