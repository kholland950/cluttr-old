<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/5/15
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (session.getAttribute("message") != null) { %>
<p class="success"><%=session.getAttribute("message")%>
</p>
<% } %>
<% session.removeAttribute("message"); %>
