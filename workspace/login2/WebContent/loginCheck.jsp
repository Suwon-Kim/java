<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="kr.ac.green.*" %>     
    
<%
	request.setCharacterEncoding("euc_kr");

	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	 
	Vector<Member> memberList = (Vector<Member>)application.getAttribute("memberList");
	
	
// 	HashMap<String, String> map = (HashMap<String, String>)application.getAttribute("map");
	
//   	 Iterator<String> keys = map.keySet().iterator();
//      while (keys.hasNext()){
//          String key = keys.next();
//          System.out.println("KEY : " + key);
//      }
	 
// 	response.sendRedirect("loginSuccess.jsp");

	// && u_pw.equals(memberList.get(i).getU_pw()) 
	String msg = null;
	boolean flag = true;
	
		for(int i = 0; i < memberList.size(); i++){
			if( !(u_id.equals(memberList.get(i).getU_id()))){
				msg = "���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�."; 
				session.setAttribute("msg", msg);
				response.sendRedirect("loginForm.jsp");
				flag = false;
				break; 
			}
		}
		
	if(flag){  
		msg = "�α��ο� �����ϼ̽��ϴ�.";
		session.setAttribute("msg", msg);
%>		
	<jsp:forward page="loginSuccess.jsp" />   
 		
<%  			
		
	}
%>

