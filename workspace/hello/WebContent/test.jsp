<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border = "2">
	<%
		for(int i = 1; i < 100; i++) {
			String color = "white";
			if(i % 2 == 0) {
				color = "#dddddd";
			}
	%>
		<tr bgcolor = "<%= color %>">
			<td><%= i %></td>
		</tr>
	<% 	
		}
	%>
	<%= str %>
	<%!
		String str = "abc";
	%>
	</table>
</body>
</html>