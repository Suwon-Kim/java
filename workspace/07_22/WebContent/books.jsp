<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "kr.ac.green.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<title>book.jsp</title>
</html>

<body>
<h4>å�� ����ϼ���</h4>
		<form action ="addBook.jsp" method = "post">
			���� : <input type = "text" name = "title" />
			<br>
			���� : <input type = "text" name = " author" />
			<br>
			������ : <input type = "text" name = "date" />
			<br>
			���� : <input type = "text" name = "price" />
			<br>
			<input type = "submit" />
			<input type = "reset" />
		</form>
		<hr>
		<%
			String path = application.getRealPath (
				application.getInitParameter("bookPath")
			);
		%>
</body>

