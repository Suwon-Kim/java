<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
<%
	String msg = "�������";
	Object o = session.getAttribute("msg");
	
	if(o != null) {
		msg = o.toString();
	}
	session.removeAttribute("msg");
%>
<div>message : <%= msg %></div>
<a href = "write.jsp">�� ���</a>
</body>
</html>