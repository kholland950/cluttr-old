package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class head_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/public/css/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n");
      out.write("    <link rel=\"apple-touch-icon\" sizes=\"57x57\" href=\"/favicon/apple-touch-icon-57x57.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"60x60\" href=\"/favicon/apple-touch-icon-60x60.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"/favicon/apple-touch-icon-72x72.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"/favicon/apple-touch-icon-76x76.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"/favicon/apple-touch-icon-114x114.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"120x120\" href=\"/favicon/apple-touch-icon-120x120.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"/favicon/apple-touch-icon-144x144.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"152x152\" href=\"/favicon/apple-touch-icon-152x152.png\">\n");
      out.write("<link rel=\"apple-touch-icon\" sizes=\"180x180\" href=\"/favicon/apple-touch-icon-180x180.png\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/favicon/favicon-32x32.png\" sizes=\"32x32\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/favicon/favicon-194x194.png\" sizes=\"194x194\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/favicon/favicon-96x96.png\" sizes=\"96x96\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/favicon/android-chrome-192x192.png\" sizes=\"192x192\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"/favicon/favicon-16x16.png\" sizes=\"16x16\">\n");
      out.write("<link rel=\"manifest\" href=\"/favicon/manifest.json\">\n");
      out.write("<link rel=\"mask-icon\" href=\"/favicon/safari-pinned-tab.svg\" color=\"#5bbad5\">\n");
      out.write("<meta name=\"apple-mobile-web-app-title\" content=\"cluttr\">\n");
      out.write("<meta name=\"application-name\" content=\"cluttr\">\n");
      out.write("<meta name=\"msapplication-TileColor\" content=\"#00aba9\">\n");
      out.write("<meta name=\"msapplication-TileImage\" content=\"/mstile-144x144.png\">\n");
      out.write("<meta name=\"theme-color\" content=\"#ffffff\">\n");
      out.write("</head>\n");
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
