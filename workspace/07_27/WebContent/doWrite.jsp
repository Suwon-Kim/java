<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.*" %>
<%@ page import = "kr.ac.green.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
	
	Doc doc = new Doc(writer, contents, date);
	
	Vector<Doc> docList = (Vector<Doc>) application.getAttribute("docList");
	if(docList == null) {
		docList = new Vector<Doc>();
		application.setAttribute("docList",docList);
	}
	
	docList.add(doc);
	response.sendRedirect("template.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>