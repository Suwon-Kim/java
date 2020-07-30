<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>메뉴</title>
</head>
<body>
	<form action = "result.jsp" method = "post">
	<b>이름 : </b><input type = "text" name = "name"><br>
	<br>
	<b>---메뉴--- </b>
	<br>
	<input type ="checkbox" name = "menu" value = "5000"> 햄버거 : 5000원 <br>
	<input type ="checkbox" name = "menu" value = "1500"> 콜라 : 1500원 <br>
	<input type ="checkbox" name = "menu" value = "2000"> 감자튀김 : 2000원 <br>
	<input type ="checkbox" name = "menu" value = "2500"> 샐러드 : 2500원 <br><br>
	<input type = "submit" value = "주문하기">
	</form>
</body>
</html>