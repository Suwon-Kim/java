package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.docs.beans.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/pages/paging.jspf");
    _jspx_dependants.add("/pages/list_sub.jspf");
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
      out.write("<table>\r\n");
      out.write("\t<caption>Doc List</caption>\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th id = \"num_td\">num</th>\r\n");
      out.write("\t\t\t<th id = \"title_td\">title</th>\r\n");
      out.write("\t\t\t<th id = \"author_td\">author</th>\r\n");
      out.write("\t\t\t<th id = \"date_td\">date</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tfoot>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th colspan = \"4\">");
      out.write('\r');
      out.write('\n');

	int pageNum = (Integer)request.getAttribute("pageNum");
	int pageCount = (Integer)request.getAttribute("pageCount");
	
	
	for(int i = 1; i <= pageCount; i++) {
		if(pageNum != i) {

      out.write("\r\n");
      out.write("\t<span class = \"linkStyle\" onclick = \"goPage(");
      out.print( i );
      out.write(")\">[");
      out.print( i );
      out.write("]</span>\r\n");
	
	} else {

      out.write("\r\n");
      out.write("\t<span class = \"normalStyle\">[");
      out.print( i );
      out.write("]</span>\r\n");

		}
	}

      out.write("\r\n");
      out.write("<form name = \"pagingForm\" action = \"");
      out.print( request.getContextPath() );
      out.write("/MainServlet\">\r\n");
      out.write("\t<input type = \"hidden\" name = \"pageNum\" />\r\n");
      out.write("\t<input type = \"hidden\" name = \"cmd\" value = \"getAll\" />\r\n");
      out.write("</form>");
      out.write("</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</tfoot>\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");

	Doc[] list = (Doc[]) request.getAttribute("list");
	if(list == null || list.length == 0) {

      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan = \"4\" >No Data</td>\r\n");
      out.write("\t</tr>\r\n");

	} else {
		for(int idx = 0; idx < list.length; idx++) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<tr class = \"doc\">\r\n");
      out.write("\t\t<td>");
      out.print( list[idx].getD_num() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print( list[idx].getD_title() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print( list[idx].getD_author() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print( list[idx].getD_date() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan = \"4\">\r\n");
      out.write("\t\t\t<div id = \"contents\">\r\n");
      out.write("\t\t\t");
      out.print( list[idx].getD_content() );
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<form action = \"");
      out.print( request.getContextPath() );
      out.write("/MainServlet\" method = \"post\">\r\n");
      out.write("\t\t\t\t<div id = \"btn\">\r\n");
      out.write("\t\t\t\t<input type = \"submit\" value = \"delete\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<input type = \"hidden\" name = \"cmd\" value = \"delete\" id = \"btnDel\" />\r\n");
      out.write("\t\t\t\t<input type = \"hidden\" name = \"d_num\" value = \"");
      out.print( list[idx].getD_num() );
      out.write("\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");

		}
	}

      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>");
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
