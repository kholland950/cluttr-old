package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.dataUtil.UserUtil;
import edu.capital.csdb.models.dataUtil.FriendsHelper;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a href=\"/\" class=\"navbar-brand\">cluttr</a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"nav\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        ");
if (session.getAttribute("user") == null) { 
      out.write("\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"login.jsp\">login</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"signup.jsp\">signup</a>\n");
      out.write("                            </li>\n");
      out.write("                        ");
 } else {
      out.write("\n");
      out.write("                        <li>\n");
      out.write("                            ");
  int n = FriendsHelper.getFriendRequests((Long)session.getAttribute("user")).size();
                                if (n == 1) {
                                    
      out.write("<a href=\"friendRequests.jsp\"><b>1 friend request</b></a>");

                                } else if (n > 1){
                                    
      out.write("<a href=\"friendRequests.jsp\"><b>");
      out.print(n);
      out.write(" friend requests</b></a>");

                                }
                            
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"/findFriends.jsp\">find friends</a></li>\n");
      out.write("                        <li>\n");
      out.write("                            <div class=\"dropdown btn navbar-btn\">\n");
      out.write("                                <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-link\">\n");
      out.write("                                    hello, ");
      out.print(UserUtil.getUsername((Long)session.getAttribute("user")));
      out.write("\n");
      out.write("                                    <b class=\"caret\"></b></a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <li><a href=\"profile.jsp\">profile</a></li>\n");
      out.write("                                    <li><a href=\"logout\">log out</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "helpers/successMessage.jsp", out, false);
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
