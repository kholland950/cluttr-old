<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/7/15
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("user") == null) {
        %> <jsp:forward page="/login.jsp"/> <%
        return;
    }
%>
