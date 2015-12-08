<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/2/15
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("error") != null) { %>
<p class="error"><%=session.getAttribute("error")%>
</p>
<% } %>
<% session.removeAttribute("error"); %>