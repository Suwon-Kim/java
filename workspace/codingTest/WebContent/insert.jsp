<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insert.jsp</title>
</head>
<body>
	<form action="MainServlet" method="post">
		model : <input type="text" name="car_model" />
		<br>
		price : <input type="text" name="car_price" />
		<br>
		description
		<br>
		<textarea rows="5" cols="40" name="car_desc"></textarea>
		<br>
		<input type="submit" value="insert" /> 
		<input type="hidden" name="cmd" value="insertCar" />
	</form>
</body>
</html>



