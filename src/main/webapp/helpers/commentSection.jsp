<%@ page import="edu.capital.csdb.models.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.capital.csdb.models.dataUtil.CommentUtil" %>
<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Comment> comments = CommentUtil.postComments(Long.parseLong(request.getParameter("postId")));
%>
<div class="row">
    <div class="comment-section">
        <br/><br/>
        <h4>comments</h4>
        <table class="table">
            <% for (Comment comment : comments) { %>
            <tr>
                <td>
                    <div>
                        <% String username = UserUtil.getUsername(comment.getUserId()); %>
                        <h5><a href="user?id=<%=comment.getUserId()%>"><%=username%></a></h5>
                    </div>
                    <div>
                        <%=comment.getText()%>
                    </div>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
