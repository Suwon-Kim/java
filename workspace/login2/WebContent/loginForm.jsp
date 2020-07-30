<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>    
<%
	String msg = "어서오세요";
	Object o = session.getAttribute("msg");
	if(o != null){
		msg = o.toString();
	}
	session.removeAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>LoginForm</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body> 
	<p class="titleStr">
		Login
	</p>
	<form id="loginForm" name="loginForm" method="post">
		<div class="centerBox">
			<label for="u_id">ID :</label> <input type="text" name="u_id" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_pw" /><br/>
			<div class="btns">
				<input type="button" value="로그인" onclick="goLogin()"/>
				<input type="button" value="회원가입" onclick="goJoin()" />
			</div>
		</div>
		<div class="msgBox">
			<%= msg %>
		</div>		
	</form>
</body>
<script> 

	function goLogin(){
		
		var inputId = document.loginForm.u_id.value;
		var inputPw = document.loginForm.u_pw.value;
		
		if(inputId.trim().length == 0){
			alert("ID를 입력하세요."); 
			document.loginForm.u_id.value = "";
			document.loginForm.u_id.focus();
		}else if(inputPw.trim().length == 0){
			alert("PW를 입력하세요.");
			document.loginForm.u_pw.value = "";
			document.loginForm.u_pw.focus();
		}else{
			var loginForm = document.getElementById("loginForm");
			loginForm.action = "loginSuccess.jsp";
			loginForm.submit();
		}
	}
	
	function goJoin(){
		location.href = "join.jsp";
	}
</script>
</html>