<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�޴�</title>
</head>
<body>
	<form action = "result.jsp" method = "post">
	<b>�̸� : </b><input type = "text" name = "name"><br>
	<br>
	<b>---�޴�--- </b>
	<br>
	<input type ="checkbox" name = "menu" value = "5000"> �ܹ��� : 5000�� <br>
	<input type ="checkbox" name = "menu" value = "1500"> �ݶ� : 1500�� <br>
	<input type ="checkbox" name = "menu" value = "2000"> ����Ƣ�� : 2000�� <br>
	<input type ="checkbox" name = "menu" value = "2500"> ������ : 2500�� <br><br>
	<input type = "submit" value = "�ֹ��ϱ�">
	</form>
</body>
</html>