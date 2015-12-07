<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/addComment" method="post">
    <div class="form-group">
        <textarea class="form-control" name="text" placeholder="how bout that post?"
                <% if (request.getParameter("comment") != null) { %>autofocus<% } %>></textarea>
    </div>
    <input type="hidden" name="postId" value="${param.postId}"/>
    <button class="btn btn-primary" type="submit">
        <span class="glyphicon glyphicon-comment"></span> comment
    </button>
</form>
