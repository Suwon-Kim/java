package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<div id = \"writeBox\">\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<legend>Write</legend>\r\n");
      out.write("\t\t<form action = \"");
      out.print( request.getContextPath() );
      out.write("/MainServlet\" method = \"post\">\r\n");
      out.write("\t\t\t<label for = \"d_title\">title : </label><input id = \"title_input\" type = \"text\" name = \"d_title\" />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<label for = \"d_author\">author : </label><input id = \"author_input\" type = \"text\" name = \"d_author\" />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<label for = \"d_content\">content : </label><textarea id = \"content_input\" name = \"d_content\"></textarea>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<div id = \"btnArea\">\r\n");
      out.write("\t\t\t<input type = \"submit\" value = \"write\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<input type = \"hidden\" name = \"cmd\" value = \"write\" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
