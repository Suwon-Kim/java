package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import kr.ac.green.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");

	Vector<Doc> docList = (Vector<Doc>) application.getAttribute("docList");
	if(docList == null) {
		docList = new Vector<Doc>();
	}
	
	Collections.sort(docList);
	
	int pageNum = 1;
	String paramPageNum = request.getParameter("pageNum");
	if(paramPageNum != null) {
		pageNum = Integer.parseInt(paramPageNum);
	}
	
	int size = docList.size();
	int perPage = 3;
	int pageCount = size / perPage;
	if((size % perPage) != 0) {
		pageCount++;
	}
	
	int start = (pageNum -1) * perPage;
	int end = start + perPage;
	if(end > size) {
		end = size;
	}
	List<Doc> list = docList.subList(start, end);

      out.write("\r\n");
      out.write("<table id = \"docList\">\r\n");
      out.write("\t<caption> - 글 목록 - </caption>\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr id = \"docListHeader\">\r\n");
      out.write("\t\t<th id = \"docNum\">번호</th>\r\n");
      out.write("\t\t<th id = \"docContents\">내용</th>\r\n");
      out.write("\t\t<th id = \"docWriter\">작성자</th>\r\n");
      out.write("\t\t<th id = \"docDate\">작성일</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t");

		if(size != 0) {
	
      out.write("\r\n");
      out.write("\t<tfoot>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan = \"4\">\r\n");
      out.write("\t\t\t");

				for(int i = 1; i <= pageCount; i++) {
					if(i == pageNum) {
			
      out.write("\r\n");
      out.write("\t\t\t\t[<b>");
      out.print( i );
      out.write("</b>]\r\n");
      out.write("\t\t\t");

					} else {
			
      out.write("\r\n");
      out.write("\t\t\t\t[<a href = \"template.jsp?contentsPage=list&pageNum=");
      out.print( i );
      out.write('"');
      out.write('>');
      out.print( i );
      out.write("</a>]\r\n");
      out.write("\t\t\t");

					}
				}
			
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</tfoot>\r\n");
      out.write("\t");

		}
	
      out.write("\t\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t");

		if(size == 0) {
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan = \"4\">no data</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");

		} else {
			for(int num = 0; num < list.size(); num++) {
				Doc doc = list.get(num);
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print( doc.getNum() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( doc.getContents() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( doc.getWriter() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( doc.getDate() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");

			}
		}
	
      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
