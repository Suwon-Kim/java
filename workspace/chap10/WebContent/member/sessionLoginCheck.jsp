<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	boolean login = memberId == null ? false : true;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α��� ���� �˻�</title>
</head>
<body>
<%
	if(login) {
%>
���̵� "<%= memberId %>"�� �α��� �� ����
<%
	} else {
%>
�α������� ���� ����
<% 
	}
%>
</body>
</html>