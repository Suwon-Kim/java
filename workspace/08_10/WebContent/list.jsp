<%@page import="java.io.UnsupportedEncodingException"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<a href="MainServlet?cmd=goInsert">insert car</a>
	<form action = "MainServlet" method = "post">
		<input type = "hidden" name = "cmd" value = "clear" />
		<input type = "submit" value = "clear">
	</form>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>Model</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		<c:choose>
			<c:when test = "${ empty list }">
			<tr>
				<td colspan = "4">Empty</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var = "temp" items = "${ list }">
					<tr>
						<td>${ temp.car_id }</td>
						<td>${ temp.car_model }</td>
						<td>${ temp.car_price }</td>
						<td>${ temp.car_desc }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>