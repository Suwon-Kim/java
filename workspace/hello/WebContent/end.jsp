<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = request.getParameter("userInput");
		str = new String(str.getBytes("8859_1"), "euc_kr");	//get����� �츮�� ���� ó�� ����� �Ѵ�. ���� ������ get����� 
		//�ѱ۷� ó�� �� �� ����.(���������� �ѱ۱��� �Ű� ���� ����) 
		//8859_1 (�� �����;� ����) -- > ���ڿ��� ���� �ٽ� ����	
	%>
	<%= str %>
		
</body>
</html>