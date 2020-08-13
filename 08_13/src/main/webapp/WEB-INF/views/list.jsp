<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<h1>list</h1>
	<hr>
		<a href="insertCar">insert car</a>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>MODEL</th>
			<th>PRICE</th>
			<th>DESCRIPTION</th>			
		</tr>	
		<c:choose>
			<c:when test="${ empty list }">
				<tr>
					<td colspan="4">empty</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="car" items="${ list }">
					<tr>
						<td>${ car.car_id }</td>
						<td>${ car.car_model }</td>
						<td>${ car.car_price }</td>
						<td>${ car.car_desc }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>





