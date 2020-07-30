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
<h4>책을 등록하세요</h4>
		<form action ="addBook.jsp" method = "post">
			제목 : <input type = "text" name = "title" />
			<br>
			저자 : <input type = "text" name = " author" />
			<br>
			발행일 : <input type = "text" name = "date" />
			<br>
			가격 : <input type = "text" name = "price" />
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

