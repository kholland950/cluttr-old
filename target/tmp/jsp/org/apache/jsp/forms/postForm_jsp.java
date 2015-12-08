package org.apache.jsp.forms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class postForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div>\n");
      out.write("    <form action=\"/addPost\" method=\"post\">\n");
      out.write("        <div class=\"form-group\" style=\"width: 80%;\">\n");
      out.write("            <textarea id=\"post-text\" class=\"post-area form-control empty\" name=\"text\" placeholder=\"whatya have to say?\"></textarea>\n");
      out.write("        </div>\n");
      out.write("        <button id=\"submit\" type=\"submit\" class=\"btn-primary btn\" disabled>post</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    var textField = $(\"#post-text\");\n");
      out.write("    var button = $(\"#submit\");\n");
      out.write("\n");
      out.write("    if (textField.val() != \"\") {\n");
      out.write("        button.prop(\"disabled\", false);\n");
      out.write("    } else {\n");
      out.write("        button.prop(\"disabled\", true);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    textField.focus(function() {\n");
      out.write("       textField.addClass(\"expanded\");\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    textField.on('input', function() {\n");
      out.write("        if (textField.val() != \"\") {\n");
      out.write("            button.prop(\"disabled\", false);\n");
      out.write("            textField.removeClass(\"empty\");\n");
      out.write("        } else {\n");
      out.write("            button.prop(\"disabled\", true);\n");
      out.write("            textField.addClass(\"empty\");\n");
      out.write("        }\n");
      out.write("    });\n");
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
