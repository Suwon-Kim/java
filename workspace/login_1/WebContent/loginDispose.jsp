<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.green.*" %>
<%@ page import = "java.util.*" %>

<% 
	String u_id = request.getParameter("u_loginId");
	String u_pw = request.getParameter("u_loginPw");
	
	Vector<JoinInfo> infoList = (Vector<JoinInfo>) application.getAttribute("infoList");
	for(int i = 0; i < infoList.size(); i++) {
		if(u_id.equals(infoList.get(i).getId()) && u_pw.equals(infoList.get(i).getPw())) {
			String ment = "로그인에 성공하셨습니다.";
%>
	<jsp:forward page="loginSuccess.jsp" />
<%			
		}
		if(u_id.equals(infoList.get(i).getId())) {
			if(!u_pw.equals(infoList.get(i).getPw())) {
				String ment = "비밀번호가 틀립니다.";
				response.sendRedirect("loginForm.jsp");
				session.setAttribute("ment", ment);
			}
		}
		if(!u_id.equals(infoList.get(i).getId())) {
			String ment = "존재하지 않는 아이디입니다.";
			response.sendRedirect("loginForm.jsp");
			session.setAttribute("ment", ment);
		}
	}
%>