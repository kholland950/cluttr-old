package org.apache.jsp.helpers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.Post;
import edu.capital.csdb.models.DAO.DAOFactory;
import java.util.List;
import edu.capital.csdb.models.dataUtil.UserUtil;

public final class postView_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Long user = null;
    if (request.getParameter("userId") != null) {
        user = Long.parseLong(request.getParameter("userId"));
    }

      out.write("\n");
      out.write("<table class=\"table table-view\">\n");
      out.write("    ");

        List<Post> posts = null;
        if (user == null) {
            posts = DAOFactory.getPostDAO().getAllRelatedPosts((Long)session.getAttribute("user"));
        } else {
            posts = DAOFactory.getPostDAO().getUserPosts(user);
        }

        if (posts.size() == 0) {
            
      out.write(" no posts yet ");

        }

        for (Post post : posts) { 
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "post.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("id", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(post.getPostId()), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</table>\n");
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
