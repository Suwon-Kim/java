<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "org.doo.*" %>
<%@ include file = "checkSession.jspf" %>
<%
	if(MemberManager.deleteMember(application, member.getU_id())) {
		session.invalidate();
		session = request.getSession();
		response.sendRedirect("loginForm.jsp");
	} else {
		session.setAttribute("msg", "회원탈퇴 중 오류가 발생했습니다.");
%>
	<jsp:foward page = "info.jsp" />
<%
	}
%>			
	
