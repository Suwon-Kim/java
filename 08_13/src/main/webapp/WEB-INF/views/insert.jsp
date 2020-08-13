<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>insert.jsp</title>
</head>
<body>
	<form action="doInsertCar" method="post">
		model : <input type="text" name="car_model" />
		<br>
		price : <input type="text" name="car_price" />
		<br>
		desc :
		<br>
		<textarea name="car_desc" cols="50" rows="5"></textarea>
		<br>
		<input type="submit" value="add car" />
	</form>
</body>
</html>