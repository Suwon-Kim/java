package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/removeMessage.jspf");
  }

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
      out.write("<!DOCTYPE html>\r\n");

	String msg = (String) session.getAttribute("msg");

	if(msg == null) {
		msg = "어서오세요";
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>LoginForm</title>\r\n");
      out.write("<link rel = \"stylesheet type = \"text/css\" href = \"css/main.css\">\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction goJoin() {\r\n");
      out.write("\t\tlocation.href = \"join.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction checkLogin() {\r\n");
      out.write("\t\tvar obj = document.loginForm;\r\n");
      out.write("\t\tobj.action = \"checkLogin.jsp\";\r\n");
      out.write("\t\tobj.method = \"post\";\r\n");
      out.write("\t\tobj.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<p class = \"titleStr\">\r\n");
      out.write("\tLogin\r\n");
      out.write("</p>\r\n");
      out.write("<form name = \"loginForm\">\r\n");
      out.write("\t<div class \"centerBox\">\r\n");
      out.write("\t\t<label for = \"u_id\">ID : </label><input type = \"text\" name = \"u_id\" /><br/>\r\n");
      out.write("\t\t<label for = \"u_pw\">PW : </label><input type = \"password\" name = \"u_pw\" /><br/>\r\n");
      out.write("\t\t<div class = \"btns\">\r\n");
      out.write("\t\t\t<input type = \"button\" value = \"로그인\" onclick = \"checkLogin()\" />\r\n");
      out.write("\t\t\t<input type = \"button\" value = \"회원가입\" onclick = \"goJoin()\" />\r\n");
      out.write("\t\t</div>\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class = \"msgBox\">\r\n");
      out.write("\t\t");
      out.print( msg );
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');

	session.removeAttribute("msg");

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
