<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import = "kr.ac.green.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Info.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<%
	String id = request.getParameter("id");

	Vector<JoinInfo> infoList = (Vector<JoinInfo>) application.getAttribute("infoList");

	JoinInfo info = infoList.get(infoList.indexOf(new JoinInfo(id)));
%>	
<body>
	
	<p class="titleStr">
	</p>
	<form name="infoForm">
		<div class="centerBox"> 
			<label for="u_id">ID :</label> <input type="text" name="u_id" value = <%=info.getId() %>/><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_pw" /><br/>
			<label for="u_re">Retry :</label> <input type="password" name="u_re" /><br/>
			<label for="u_name">Name :</label> <input type="text" name="u_name" value = <%=info.getName() %> /><br/>
			<label for="u_nick">Nick :</label> <input type="text" name="u_nick" /><br/>				
			<div class="btns">
				<input type="button" value="수정"/>
				<input type="button" value="취소"/>
				<input type="button" value="회원탈퇴"/>
			</div>
		</div>
		<div class="msgBox">
			put message, here
		</div>		
	</form>	
</body>
</html>