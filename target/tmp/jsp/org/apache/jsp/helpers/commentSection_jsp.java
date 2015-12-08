package org.apache.jsp.helpers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.Comment;
import java.util.List;
import edu.capital.csdb.models.dataUtil.CommentUtil;
import edu.capital.csdb.models.dataUtil.UserUtil;

public final class commentSection_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    List<Comment> comments = CommentUtil.postComments(Long.parseLong(request.getParameter("postId")));

      out.write("\n");
      out.write("<div class=\"row\">\n");
      out.write("    <div class=\"comment-section\">\n");
      out.write("        <br/><br/>\n");
      out.write("        <h4>comments</h4>\n");
      out.write("        <table class=\"table\">\n");
      out.write("            ");
 for (Comment comment : comments) { 
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <div>\n");
      out.write("                        ");
 String username = UserUtil.getUsername(comment.getUserId()); 
      out.write("\n");
      out.write("                        <h5><a href=\"user?id=");
      out.print(comment.getUserId());
      out.write('"');
      out.write('>');
      out.print(username);
      out.write("</a></h5>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        ");
      out.print(comment.getText());
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
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
