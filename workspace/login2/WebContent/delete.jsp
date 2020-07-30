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
	
	String msg = "삭제가 완료되었습니다.";
	if(u_pw.equals(original.getU_pw())){
		memberList.remove(temp);
		session.invalidate();
		response.sendRedirect("loginForm.jsp");
	}else{
		msg ="비밀번호가 일치하지 않습니다.";
		response.sendRedirect("info.jsp?u_id=" + u_id);
	}
	
	session.setAttribute("msg", msg);
	
%>