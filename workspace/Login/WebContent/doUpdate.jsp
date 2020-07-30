<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file = "checkSession.jspf" %>

<%@ page import = "org.doo.*" %>
<%
	request.setCharacterEncoding("euc-kr");
	member.setU_pw(request.getParameter("u_pw"));
	member.setU_nick(request.getParameter("u_nick"));
	
	MemberManager.updateMember(application, member);
	session.setAttribute("msg", "회원정보가 수정되었습니다.");
	response.sendRedirect("loginSuccess.jsp");
%>