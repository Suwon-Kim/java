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
			String ment = "�α��ο� �����ϼ̽��ϴ�.";
%>
	<jsp:forward page="loginSuccess.jsp" />
<%			
		}
		if(u_id.equals(infoList.get(i).getId())) {
			if(!u_pw.equals(infoList.get(i).getPw())) {
				String ment = "��й�ȣ�� Ʋ���ϴ�.";
				response.sendRedirect("loginForm.jsp");
				session.setAttribute("ment", ment);
			}
		}
		if(!u_id.equals(infoList.get(i).getId())) {
			String ment = "�������� �ʴ� ���̵��Դϴ�.";
			response.sendRedirect("loginForm.jsp");
			session.setAttribute("ment", ment);
		}
	}
%>