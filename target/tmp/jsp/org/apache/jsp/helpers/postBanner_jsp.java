package org.apache.jsp.helpers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.capital.csdb.models.dataUtil.LikeUtil;
import edu.capital.csdb.models.Post;
import edu.capital.csdb.models.DAO.DAOFactory;

public final class postBanner_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write('\n');

    Post post = DAOFactory.getPostDAO().getPost(Long.parseLong(request.getParameter("id")));
    boolean postPage = false;
    if (request.getParameter("postPage") != null) {
        postPage = true;
    }

      out.write("\n");
      out.write("<div class=\"post-banner\">\n");
      out.write("    <h5>\n");
      out.write("        <span id=\"num-likes");
      out.print(post.getPostId());
      out.write("\">\n");
      out.write("            ");
 if (post.likes.size() == 0) { 
      out.write("\n");
      out.write("                no likes\n");
      out.write("            ");
 } else if (post.likes.size() == 1) { 
      out.write("\n");
      out.write("                1 like\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                ");
      out.print(post.likes.size());
      out.write(" likes\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </span>\n");
      out.write("         |\n");
      out.write("        <span id=\"num-comments");
      out.print(post.getPostId());
      out.write("\">\n");
      out.write("            ");
 if (post.comments.size() == 0)  { 
      out.write("\n");
      out.write("                no comments\n");
      out.write("            ");
 } else if (post.comments.size() == 1) { 
      out.write("\n");
      out.write("                1 comment\n");
      out.write("            ");
 } else { 
      out.write("\n");
      out.write("                ");
      out.print(post.comments.size());
      out.write(" comments\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </span>\n");
      out.write("    </h5>\n");
      out.write("\n");
      out.write("    ");

        boolean liked = LikeUtil.userLikesPost((Long) session.getAttribute("user"), post.getPostId());
        if (!liked) { 
      out.write("\n");
      out.write("        <button id=\"like");
      out.print(post.getPostId());
      out.write("\" class=\"btn btn-sm btn-primary\">\n");
      out.write("            <span class=\"glyphicon glyphicon-thumbs-up\"></span> like\n");
      out.write("        </button>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"liked-label\" id=\"liked");
      out.print(post.getPostId());
      out.write('"');
      out.write(' ');
 if (!liked) { 
      out.write(" hidden ");
 } 
      out.write(">\n");
      out.write("        <h5 style=\"float: left\">liked</h5>\n");
      out.write("        <span class=\"ok glyphicon glyphicon-ok\" style=\"color:#229933;\"></span>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
 if (!postPage) { 
      out.write("\n");
      out.write("        <a href=\"../showPost.jsp?id=");
      out.print(post.getPostId());
      out.write("&comment=true\" class=\"btn btn-sm btn-primary\">\n");
      out.write("            <span class=\"glyphicon glyphicon-comment\"></span> comment\n");
      out.write("        </a>\n");
      out.write("        <a href=\"../showPost.jsp?id=");
      out.print(post.getPostId());
      out.write("\" class=\"btn btn-sm btn-primary\">\n");
      out.write("            <span class=\"glyphicon glyphicon-share-alt\"></span> go to post\n");
      out.write("        </a>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    if (likeButtons == undefined) {\n");
      out.write("        var likeButtons = [];\n");
      out.write("    }\n");
      out.write("    likeButtons[");
      out.print(post.getPostId());
      out.write("] = $(\"#like");
      out.print(post.getPostId());
      out.write("\");\n");
      out.write("    likeButtons[");
      out.print(post.getPostId());
      out.write("].click(function() {\n");
      out.write("        $.ajax({\n");
      out.write("            url: 'like',\n");
      out.write("            data: {\n");
      out.write("                user: '");
      out.print(session.getAttribute("user"));
      out.write("',\n");
      out.write("                post: '");
      out.print(post.getPostId());
      out.write("'\n");
      out.write("            },\n");
      out.write("            error: function() {\n");
      out.write("                $('#info').html('<p>An error has occurred</p>');\n");
      out.write("            },\n");
      out.write("            success: function(data) {\n");
      out.write("                likeButtons[");
      out.print(post.getPostId());
      out.write("].hide();\n");
      out.write("                $(\"#liked");
      out.print(post.getPostId());
      out.write("\").show();\n");
      out.write("                $(\"#num-likes");
      out.print(post.getPostId());
      out.write("\").text(\"");
      out.print(post.likes.size()+1);
      out.write(" like");
if (post.likes.size()>=1){
      out.write('s');
}
      out.write("\");\n");
      out.write("            },\n");
      out.write("            type: 'POST'\n");
      out.write("        });\n");
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
