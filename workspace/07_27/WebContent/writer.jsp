<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<fieldset>
	<legend>글쓰기</legend>
	<form action = "doWrite.jsp" method = "post">
	<input type = "text" name = "writer" placeholder = "작성자" />
	<br><br>
	<textarea name = "contents" rows = "5" placeholder = "내용"></textarea>
	<br>
	<input type = "submit" value = "완료" />
	</form>
</fieldset>
</body>
</html>