<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("euc_kr");
	String data = request.getParameter("inputData");
	String path = 
		application.getRealPath(application.getInitParameter("dataPath"));
	if(data != null) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(path, true);
			pw = new PrintWriter(fw);
			pw.println(data);
			pw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch(Exception e) {}
			try {
				fw.close();
			} catch(Exception e) {}
		}
	}
	response.sendRedirect("list.jsp");
%>