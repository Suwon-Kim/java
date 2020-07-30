<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Calendar 클래스 사용</title>
</head>
<body>

<% 
	Calendar cal = Calendar.getInstance();
%>
오늘은
<%= cal.get(Calendar.YEAR) %> 년 
<%= cal.get(Calendar.MONTH) + 1 %>월
<%= cal.get(Calendar.DATE) %>일
<%= cal.get(Calendar.HOUR_OF_DAY) %>시

	
입니다.
</body>
</html>