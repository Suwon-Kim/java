<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	String msg = (String) session.getAttribute("msg");

	if(msg == null) {
		msg = "어서오세요";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>LoginForm</title>
<link rel = "stylesheet type = "text/css" href = "css/main.css">
<script>
	function goJoin() {
		location.href = "join.jsp";
	}
	
	function checkLogin() {
		var obj = document.loginForm;
		obj.action = "checkLogin.jsp";
		obj.method = "post";
		obj.submit();
	}
</script>
</head>
<body>
<p class = "titleStr">
	Login
</p>
<form name = "loginForm">
	<div class "centerBox">
		<label for = "u_id">ID : </label><input type = "text" name = "u_id" /><br/>
		<label for = "u_pw">PW : </label><input type = "password" name = "u_pw" /><br/>
		<div class = "btns">
			<input type = "button" value = "로그인" onclick = "checkLogin()" />
			<input type = "button" value = "회원가입" onclick = "goJoin()" />
		</div>		
	</div>
	<div class = "msgBox">
		<%= msg %>
	</div>
</form>
</body>
</html>
<%@ include file = "removeMessage.jspf" %>