<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<link rel = "stylesheet" media = "screen" type = "text/css " href = "css/style.css" />
	<script src = "scripts/script.js"></script>
</head>
<body>
	<div class = "pageElement">
		<jsp:include page = "pages/insert.jsp" />
	</div>
	<div class = "pageElement">
		<jsp:include page = "pages/${ pageInfo.bottom }" />
	</div>
</body>
</html>