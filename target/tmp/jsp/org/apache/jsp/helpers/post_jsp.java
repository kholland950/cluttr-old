package org.apache.jsp.helpers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.dataUtil.UserUtil;
import edu.capital.csdb.models.Post;
import edu.capital.csdb.models.DAO.DAOFactory;
import edu.capital.csdb.models.dataUtil.LikeUtil;

public final class post_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    Post post = DAOFactory.getPostDAO().getPost(Long.parseLong(request.getParameter("id")));

      out.write("\n");
      out.write("<div class=\"post\">\n");
      out.write("    <a href=\"user?id=");
      out.print(post.getUserId());
      out.write('"');
      out.write('>');
      out.print(UserUtil.getUsername(post.getUserId()));
      out.write("</a>\n");
      out.write("    <div id=\"post-text");
      out.print(post.getPostId());
      out.write("\" class=\"post-text preview\">");
      out.print(post.getText());
      out.write("</div>\n");
      out.write("    <a href=\"showPost.jsp?id=");
      out.print(post.getPostId());
      out.write("\" id=\"overflow");
      out.print(post.getPostId());
      out.write("\" class=\"overflow glyphicon glyphicon-option-horizontal hidden\"></a>\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "postBanner.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("id", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode(String.valueOf(post.getPostId()), request.getCharacterEncoding()), out, false);
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var postText = $(\"#post-text");
      out.print(post.getPostId());
      out.write("\");\n");
      out.write("    if (postText[0].offsetHeight < postText[0].scrollHeight) {\n");
      out.write("        $(\"#overflow");
      out.print(post.getPostId());
      out.write("\").removeClass(\"hidden\");\n");
      out.write("    }\n");
      out.write("</script>\n");
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
