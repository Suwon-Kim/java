<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>
<%
	request.setCharacterEncoding("euc_kr");

	String u_id = request.getParameter("u_id");
	String u_name = request.getParameter("u_name");
	String u_nick = request.getParameter("u_nick");
	String u_pw = request.getParameter("u_pw");

	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	
	Member original = memberList.get(memberList.indexOf(new Member(u_id)));
	
	String msg = "������ �Ϸ�Ǿ����ϴ�.";
	if(u_pw.equals(original.getU_pw())){
		original.setU_name(u_name);
		original.setU_nick(u_nick);
// 	 	response.sendRedirect("loginSuccess.jsp");
%>
	 <jsp:forward page="loginSuccess.jsp" /> 
<% 		
	}else{
		msg = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		response.sendRedirect("info.jsp?u_id=" + u_id); 
	}
	
	
	session.setAttribute("msg", msg);
// 	response.sendRedirect("loginSuccess.jsp");
%>
