<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %> 
<%
	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	
	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	
	Member temp = new Member(u_id);
	
	Member original = memberList.get(memberList.indexOf(temp));
	
	String msg = "������ �Ϸ�Ǿ����ϴ�.";
	if(u_pw.equals(original.getU_pw())){
		memberList.remove(temp);
		session.invalidate();
		response.sendRedirect("loginForm.jsp");
	}else{
		msg ="��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
		response.sendRedirect("info.jsp?u_id=" + u_id);
	}
	
	session.setAttribute("msg", msg);
	
%>