<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate();

	session = request.getSession();
	session.setAttribute("msg", "로그아웃 되었습니다.");
%>
<jsp:forward page = "loginForm.jsp" />