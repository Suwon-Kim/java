<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "org.doo.*" %>
<%@ page import = "java.util.*" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id = "member" class = "org.doo.Member" />
<jsp:setProperty property = "*" name = "member" />

<%
	String msg = "회원가입 성공";
	String nextPage = "loginForm.jsp";
	if(!MemberManager.addMember(application, member)) {
		msg = "이미 존재하는 아이디입니다.";
		session.setAttribute("tempMember", member);
		nextPage = "join.jsp";
	}
	session.setAttribute("msg", msg);
	response.sendRedirect(nextPage);
	
%>
