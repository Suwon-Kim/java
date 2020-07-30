<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>  
<%
	request.setCharacterEncoding("euc_kr");

	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	 
	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	
	Member member = new Member(u_id);
	
// 	Member member = memberList.get(memberList.indexOf(new Member(u_id)));

%>
<%
	String msg = u_id+"님 어서오세요";
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
<title>Login Success</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	<p class="titleStr">
		Success!!
	</p>
<!-- 	<form name="successForm"> -->
		<div class="centerBox">				
			<div class="btns">
				<input type="button" value="정보보기" onclick="goSelect(<%=member.getU_id() %>)" />
				<input type="button" value="로그아웃" onclick="goLogout()" />
			</div>
		</div> 
		<div class="msgBox">
			<%= msg %>
		</div>
<!-- 	</form>	   -->
<script>
// 	function select(u_id){
// 		var myForm = document.successForm;
// 		myForm.u_id.value = u_id; 
// 		myForm.submit();
// 	}
 	 
	function goSelect(u_id){ 
		console.log("정보보기"); 
		location.href = "info.jsp?u_id="+u_id;
	}	
	 
	function goLogout(){
		console.log("로그아웃");
		<%
			session.invalidate();
		%>
		location.href = "loginForm.jsp";
	}
</script>
</body>

<!-- <form id="hiddenForm" name="hiddenForm" action="info.jsp"> -->
<!-- 	<input type="hidden" name="u_id" /> -->
<!-- </form> -->

</html>