<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import="java.util.*" %>    
<%@ page import="kr.ac.green.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	
%>
<%
	String msg = "어서오세요";
	Object o = session.getAttribute("msg");
	if(o != null){
		msg = o.toString();
	}
	session.removeAttribute("msg");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>	
	<p class="titleStr">
		Join Member
	</p>
	<form id="joinForm" name="joinForm" method="post" >
		<div class="centerBox">
			<label for="u_id">ID :</label> <input type="text" id="u_id" name="u_id" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_pw" /><br/>
			<label for="u_re">Retry :</label> <input type="password" name="u_re" /><br/>
			<label for="u_name">Name :</label> <input type="text" name="u_name" /><br/>
			<label for="u_nick">Nick :</label> <input type="text" name="u_nick" /><br/>				
			<div class="btns">
				<input type="button" value="회원가입" onclick="checkInput()" />
				<input type="button" value="취소" onclick="goBack()" />		
			</div>
		</div> 
		<div class="msgBox" id="msg">
			<%= msg %>
		</div>	
	</form>	
</body>
<script>  
	function checkInput(){
		var inputId = document.joinForm.u_id.value;
		var inputPw = document.joinForm.u_pw.value;
		var inputRe = document.joinForm.u_re.value;
		var inputName = document.joinForm.u_name.value;
		var inputNick = document.joinForm.u_nick.value;
		
		
		if(inputId.trim().length == 0){
			alert("ID를 입력하세요.");
			document.joinForm.u_id.value = "";
			document.joinForm.u_id.focus();
		}else if(inputPw.trim().length == 0){
			alert("PW를 입력하세요.");
			document.joinForm.u_pw.value = "";
			document.joinForm.u_pw.focus();
		}else if(inputRe.trim().length == 0){
			alert("Retry를 입력하세요.");
			document.joinForm.u_re.value = "";
			document.joinForm.u_re.focus();
		}else if(inputPw != inputRe){
			alert("Retry가 일치하지 않습니다.");
			document.joinForm.u_re.value = "";
			document.joinForm.u_re.focus();
		}else if(inputName.trim().length == 0){
			alert("Name을 입력하세요.");
			document.joinForm.u_name.value = "";
			document.joinForm.u_name.focus();
		}else if(inputNick.trim().length == 0){
			alert("Nick을 입력하세요.");
			document.joinForm.u_nick.value = "";
			document.joinForm.u_nick.focus();
		}else{
			var joinForm = document.getElementById("joinForm");
			joinForm.action = "joinSuccess.jsp";
			joinForm.submit();
		}		
	}
	
	function goBack(){
		location.href ="loginForm.jsp";
	}
</script>
</html>