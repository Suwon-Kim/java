<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>     
<%
	String u_id = request.getParameter("u_id");
	
	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	Member member = memberList.get(memberList.indexOf(new Member(u_id)));
%>
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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Info.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>

<body>
	<p class="titleStr">
		Info
	</p>
	<form name="infoForm" id="infoForm">
		<div class="centerBox">
			<label for="u_id">ID :</label> <input type="text" name="u_id" id="u_id" value="<%=member.getU_id()%>" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_pw" /><br/>
			<label for="u_re">Retry :</label> <input type="password" name="u_re" value="<%=member.getU_re()%>" readonly /><br/>
			<label for="u_name">Name :</label> <input type="text" name="u_name" value="<%=member.getU_name()%>" /><br/>
			<label for="u_nick">Nick :</label> <input type="text" name="u_nick" value="<%=member.getU_nick()%>" /><br/>				
			<div class="btns">
				<input type="button" value="수정" onclick="todo('update')" />
				<input type="button" value="취소" onclick="goBack()"/> 
				<input type="button" value="회원탈퇴" onclick="todo('delete')"/>
			</div>
		</div>
		<div class="msgBox">
			<%= msg %>
		</div>		 
	</form>	 
	<script>
		function goBack(){
			var u_id = document.getElementById("u_id");
			 window.history.back();
// 			location.href = "loginSuccess.jsp?u_id"+u_id;
		}
		
		function todo(){
			var what = arguments[0];
			
			// modifyForm을 가진 id값을 가져와서 action속성을 >>
			var infoForm = document.getElementById("infoForm");
			infoForm.action = what + ".jsp";
			
			infoForm.submit();
		}
	</script>
</body>
</html>