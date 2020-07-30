package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class processJoining_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("utf-8");

      out.write('\r');
      out.write('\n');
      chap08.member.MemberInfo memberInfo = null;
      synchronized (_jspx_page_context) {
        memberInfo = (chap08.member.MemberInfo) _jspx_page_context.getAttribute("memberInfo", PageContext.PAGE_SCOPE);
        if (memberInfo == null){
          memberInfo = new chap08.member.MemberInfo();
          _jspx_page_context.setAttribute("memberInfo", memberInfo, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("memberInfo"), request);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("memberInfo"), "password",
 memberInfo.getId() );
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>가입</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("<table width = \"400\" border = \"1\" cellpadding = \"0\" cellsacing = \"0\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>아이디</td>\r\n");
      out.write("\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((chap08.member.MemberInfo)_jspx_page_context.findAttribute("memberInfo")).getId())));
      out.write("</td>\r\n");
      out.write("\t<td>암호</td>\r\n");
      out.write("\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((chap08.member.MemberInfo)_jspx_page_context.findAttribute("memberInfo")).getPassword())));
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>이름</td>\r\n");
      out.write("\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((chap08.member.MemberInfo)_jspx_page_context.findAttribute("memberInfo")).getName())));
      out.write("</td>\r\n");
      out.write("\t<td>이메일</td>\r\n");
      out.write("\t<td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((chap08.member.MemberInfo)_jspx_page_context.findAttribute("memberInfo")).getEmail())));
      out.write("</td>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
