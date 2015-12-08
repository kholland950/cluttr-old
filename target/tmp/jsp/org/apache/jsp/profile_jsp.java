package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.dataUtil.UserUtil;
import edu.capital.csdb.models.User;
import java.util.List;
import edu.capital.csdb.models.dataUtil.FriendsHelper;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/helpers/authCheck.jsp", out, false);
      out.write('\n');

    Long userId;
    Long meId = (Long)session.getAttribute("user");
    String username;
    boolean isMe = true;
    if (request.getParameter("id") != null) {
        userId = Long.parseLong(request.getParameter("id"));
        isMe = userId.equals(meId);
    } else {
        userId = (Long)session.getAttribute("user");
    }
    username = UserUtil.getUsername(userId);

    boolean areFriends = true;
    if (!isMe) {
        areFriends = FriendsHelper.areFriends(userId, (Long)session.getAttribute("user"));
    }

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>cluttr | ");
      out.print(username);
      out.write("</title>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/head.jsp", out, false);
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"row row-height\">\n");
      out.write("        <h3 class=\"profile-header\">\n");
      out.write("            ");
 if (isMe) { 
      out.write("your");
 } else { 
      out.print(username);
      out.write('\'');
      out.write('s');
 } 
      out.write(" profile</h3>\n");
      out.write("        ");

            Long userLoggedIn = (Long)session.getAttribute("user");
            if (!userLoggedIn.equals(userId)) {
                
      out.write("\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"friends-label\">\n");
      out.write("                        ");
 if (FriendsHelper.friendRequestExists(userId, userLoggedIn)) { 
      out.write("\n");
      out.write("                            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/forms/acceptFriendForm.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("requestor", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(userId), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("                        ");
 } else if (!FriendsHelper.areFriends(userLoggedIn, userId)) {
                            if (FriendsHelper.friendRequestExists(userLoggedIn, userId)) { 
      out.write("\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/helpers/requestSent.jsp", out, false);
      out.write("\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/forms/friendRequestForm.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("target", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(userId), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        ");
 } else if (FriendsHelper.areFriends(userLoggedIn, userId)) { 
      out.write("\n");
      out.write("                            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/helpers/friendLabel.jsp", out, false);
      out.write("\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-8\">\n");
      out.write("            <h3>posts</h3>\n");
      out.write("            ");
 if (!areFriends) { 
      out.write("\n");
      out.write("                you must be friends to view this user's posts\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/helpers/postView.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("userId", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(userId), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-3\">\n");
      out.write("            <h3>friends</h3>\n");
      out.write("            ");
 List<User> friends = FriendsHelper.getAllFriends(userId); 
      out.write("\n");
      out.write("\n");
      out.write("            ");

                if (isMe) {
            
      out.write("\n");
      out.write("            you have\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            ");
      out.print(username);
      out.write(" has\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("            ");
 if (friends.size() == 0) { 
      out.write("\n");
      out.write("            no friends yet.\n");
      out.write("            <p>find friends <a href=\"findFriends.jsp\">here</a>.</p>\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("            ");
      out.print(friends.size());
      out.write(" friends.\n");
      out.write("            <hr/>\n");
      out.write("            <table class=\"find-friends-table\">\n");
      out.write("                ");

                    int limit = 15;
                    int i = 0;
                    for (User user : friends) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"user?id=");
      out.print(user.getUserId());
      out.write('"');
      out.write('>');
      out.print(user.getUsername());
      out.write("</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        if (i == limit) break;
                        i++;
                    }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <hr/>\n");
      out.write("            <a href=\"friends.jsp?id=");
      out.print(userId);
      out.write("\">see all friends</a>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
