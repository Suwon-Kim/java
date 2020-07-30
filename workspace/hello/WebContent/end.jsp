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
		str = new String(str.getBytes("8859_1"), "euc_kr");	//get방식은 우리가 직적 처리 해줘야 한다. 하지 않으면 get방식은 
		//한글로 처리 할 수 없다.(서양사람들이 한글까지 신경 쓰지 않음) 
		//8859_1 (한 바이터씩 만들어냄) -- > 문자열을 새로 다시 만들어냄	
	%>
	<%= str %>
		
</body>
</html>