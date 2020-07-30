<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp</title>
</head>
<body>
<h1>A</h1>
<hr>
<jsp:include page = "middle.jsp" >
	<jsp:param value = "myValue" name = "myKey" />
</jsp:include>
<hr>

</body>
</html>