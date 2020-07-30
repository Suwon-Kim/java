<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.ac.green.*"%> 
<%
	request.setCharacterEncoding("euc_kr");

	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	String u_re = request.getParameter("u_re");
	String u_name = request.getParameter("u_name");
	String u_nick = request.getParameter("u_nick");

	Vector<Member> memberList = (Vector<Member>) application.getAttribute("memberList");
	if (memberList == null) {
		memberList = new Vector<Member>();
		application.setAttribute("memberList", memberList);
	} 
	
// 	HashMap<String, String> map = (HashMap<String, String>)application.getAttribute("map");
// 	if (map == null) {
// 		map = new HashMap<String, String>();
// 		application.setAttribute("map", map);
// 	}
	
	String msg = null;
	Member member = new Member(u_id, u_pw, u_re, u_name, u_nick);

	boolean flag = true;
	
		for(int i = 0; i < memberList.size(); i++){
			if(u_id.equals(memberList.get(i).getU_id())){
				msg = "아이디가 중복되었습니다.";
				session.setAttribute("msg", msg);
				response.sendRedirect("join.jsp");
				flag = false;
				break;
			}
		}
	
	if(flag){
		memberList.add(member);
// 		map.put(u_id, u_pw);
		response.sendRedirect("loginForm.jsp");
		session.setAttribute("msg", msg);
	}
%>