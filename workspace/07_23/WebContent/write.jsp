<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>write.jsp</title>
<%--
	��ȣ, ����, ����, �۾���, �ۼ���, ��й�ȣ
--%>
</head>
<body>
	<form action = "list.jsp" method = "post">
	<input type = "text" name = "title" placeholder ="����"/>
	<br>
	<input type = "text" name = "writer" placeholder = "�۾���" />
	<br>
	<input type = "password" name = "pw" placeholder = "��й�ȣ" />
	<br>
	<textarea name = "contents" rows = "5" cols = "50" placeholder = "������ �Է��ϼ��� "></textarea>
	<br>
	<input type = "submit" />
	<input type = "reset" />
	</form>
</body>
</html>