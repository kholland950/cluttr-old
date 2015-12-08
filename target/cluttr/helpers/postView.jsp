<%@ page import="edu.capital.csdb.models.Post" %>
<%@ page import="edu.capital.csdb.models.DAO.DAOFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.capital.csdb.models.dataUtil.UserUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: kevinholland
  Date: 12/6/15
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Long user = null;
    if (request.getParameter("userId") != null) {
        user = Long.parseLong(request.getParameter("userId"));
    }
%>
<table class="table table-view table-responsive">
    <%
        List<Post> posts = null;
        if (user == null) {
            posts = DAOFactory.getPostDAO().getAllRelatedPosts((Long)session.getAttribute("user"));
        } else {
            posts = DAOFactory.getPostDAO().getUserPosts(user);
        }

        if (posts.size() == 0) {
            %> no posts yet <%
        }

        for (Post post : posts) { %>
            <tr>
                <td>
                    <jsp:include page="post.jsp">
                        <jsp:param name="id" value="<%=post.getPostId()%>"/>
                    </jsp:include>
                </td>
            </tr>
    <% } %>
</table>
