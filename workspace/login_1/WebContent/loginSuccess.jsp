<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("u_loginId");
%>
<%
	String msg = "어서오세요";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Success</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<!-- session.invalidate() -->
</head>

<body>
	<p class="titleStr">
		Success!!
	</p>
<!-- 	<form name="successForm"> -->
		<div class="centerBox">				
			<div class="btns">
				<input type="button" value="정보보기" onclick = "select(id)" />
				<input type="button" value="로그아웃" />
			</div>
		</div>
		<div class="msgBox">
			<%= id +"님 " + msg %>
		</div>
		
<!-- 	</form>	 -->
	<script>
		function select(id){
			location.href="info.jsp?id=" + id;
		}
	</script>
</body>
</html>