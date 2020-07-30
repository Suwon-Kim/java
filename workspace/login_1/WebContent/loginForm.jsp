<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import = "kr.ac.green.*" %>
<%@ page import = "java.util.*" %>
<%
	String ment = "어서오세요 !";
	Object o = session.getAttribute("msg");
	if(o != null) {
		ment = o.toString();
	}
	session.removeAttribute(ment);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	function confirm() {
		var checkForm = document.getElementById("check");
		loginForm.action = "loginDispose.jsp";
		loginForm.submit();
	}
</script>
<html>

<head>
	<title>LoginForm</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
	<p class="titleStr">
		Login
	</p>
	<form id = "check" method = "post" name="loginForm">
		<div class="centerBox">
			<label for="u_id">ID :</label> <input type="text" name="u_loginId" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_loginPw" /><br/>
			<div class="btns">
				<input type="button" value="로그인" onclick = "confirm()" />
				<input type="button" value="회원가입" onclick = "location.href = 'join.jsp'"/>
			</div>
		</div>
		<div class="msgBox">
			<%= ment %>
		</div>		
	</form>
</body>
</html>