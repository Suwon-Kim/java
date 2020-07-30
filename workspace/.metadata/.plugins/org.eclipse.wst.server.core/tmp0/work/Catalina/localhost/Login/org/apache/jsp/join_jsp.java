package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.doo.*;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	String msg = (String)session.getAttribute("msg");
	if(msg == null) {
		msg = "모든 항목은 필수입력 입니다.";
	}
	Member member = (Member)session.getAttribute("tempMember");
	if(member == null) {
		member = MemberManager.getBlankMember();
	}
	session.removeAttribute("tempMember");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel = \"stylesheet\" type = \"text/css\" href = \"css/main.css\">\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction checkAndMove() {\r\n");
      out.write("\t\tvar obj = document.joinForm;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar flag = true;\r\n");
      out.write("\t\tfor(var i = 0; flag && i < obj.length; i++) {\r\n");
      out.write("\t\t\tif(obj[i].type.toLowerCase() != \"button\") {\r\n");
      out.write("\t\t\t\tif(obj[i].value.trim().length == 0) {\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"msg\").innerHTML = \r\n");
      out.write("\t\t\t\t\t\t\"필수입력항목 누락 : \" + obj[i].title;\r\n");
      out.write("\t\t\t\t\t\tflag = false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(flag) {\r\n");
      out.write("\t\t\tif(obj.u_pw.value != obj.u_re.value) {\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"msg\").innerHTML = \"비밀번호가 일치 하지 않습니다.\";\r\n");
      out.write("\t\t\t\tflag = false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(flag) {\r\n");
      out.write("\t\t\tobj.method = \"post\";\r\n");
      out.write("\t\t\tobj.action = \"doJoin.jsp\";\r\n");
      out.write("\t\t\tobj.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction cancelJoin() {\r\n");
      out.write("\t\tlocation.href = \"cancelJoin.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<p class = \"titleStr\">\r\n");
      out.write("\t\tJoin Member\r\n");
      out.write("\t</p>\r\n");
      out.write("\t<form name = \"joinForm\">\r\n");
      out.write("\t\t<div class =\"centerBox\">\r\n");
      out.write("\t\t<label for = \"u_id\">ID : </label>\r\n");
      out.write("\t\t<input type = \"text\" name = \"u_id\" title = \"ID\" value = \"");
      out.print( member.getU_id() );
      out.write("\" /><br/>\r\n");
      out.write("\t\t<label for = \"u_pw\">PW : </label>\r\n");
      out.write("\t\t<input type = \"password\" name = \"u_pw\" title = \"PASSWORD\" /><br/>\r\n");
      out.write("\t\t<label for = \"u_re\">Retry :</label>\r\n");
      out.write("\t\t<input type = \"password\" name = \"u_re\" title = \"RETRY\" /><br/>\r\n");
      out.write("\t\t<label for = \"u_name\">Name : </label>\r\n");
      out.write("\t\t<input type = \"text\" name = \"u_name\" title = \"NAME\" value = \"");
      out.print( member.getU_name() );
      out.write("\" />\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<label for = \"u_nick\">Nick : </label>\r\n");
      out.write("\t\t<input type = \"text\" name = \"u_nick\" title = \"NICKNAME\"\r\n");
      out.write("\t\t\tvalue = \"");
      out.print( member.getU_nick() );
      out.write("\" />\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<div class = \"btns\">\r\n");
      out.write("\t\t\t<input type = \"button\" value = \"회원가입\" onclick = \"checkAndMove()\" />\r\n");
      out.write("\t\t\t<input type = \"button\" value = \"취소\" onclick = \"cancelJoin()\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class = \"msgBox\" id = \"msg\">\r\n");
      out.write("\t\t");
      out.print( msg );
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
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
