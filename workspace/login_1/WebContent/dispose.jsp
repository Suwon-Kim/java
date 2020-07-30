<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "kr.ac.green.*" %>
<%@ page import = "java.util.*" %>

<% 
	String id = request.getParameter("u_id");
	String password = request.getParameter("u_pw");
	String re = request.getParameter("u_re");
	String name = request.getParameter("u_name");
	String nick = request.getParameter("u_nick");
	
	JoinInfo joinInfo = new JoinInfo(id, password, re, name, nick);
	Vector<JoinInfo> infoList = (Vector<JoinInfo>) application.getAttribute("list");
	if(infoList == null) {
		infoList = new Vector<JoinInfo>();
		application.setAttribute("infoList", infoList);
	}
	boolean flag = true;
	for(int i = 0; i < infoList.size(); i++) {
		if(id.equals(infoList.get(i).getId())) {
			String ment = "중복된 아이디가 있습니다";
			session.setAttribute("ment", ment);
			response.sendRedirect("join.jsp");
			flag = false;
		}
	}
	if(flag == true) {
		infoList.add(joinInfo);
		response.sendRedirect("loginForm.jsp");
	}
%>

