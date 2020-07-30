<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "java.util.Map" %>
<%
	//�Ķ������ ���ڵ��� ������ (POST ���) ����� requestBody�� �ش��
	//get������� �ѱ��� �����ϸ� ���� �� �� ����
	request.setCharacterEncoding("utf-8"); // <<< post����϶��� ��� �� �� �ִ�.
	//request�� �Ķ���� �����ϱ� ���� �ݵ�� ������� �Ѵ�.  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��û �Ķ���� ���</title>
</head>
<body>
<b>request.getParameter() �޼ҵ� ���</b><br>
name �Ķ���� = <%= request.getParameter("name") %><br>
address �Ķ���� = <%= request.getParameter("address") %>
<p>
<b>request.getParameterValues() �޼ҵ� ���</b><br>
<%
	String[] values = request.getParameterValues("pet");
	if(values != null) {
		for(int i = 0; i < values.length; i++) {
%>		
	<%= values[i] %>
<%
		}
	}
%>	
<p>
<b>request.getParameterNames() �޼��� ���</b>
<%
	Enumeration paramEnum = request.getParameterNames();
	while(paramEnum.hasMoreElements()) {
		String name = (String)paramEnum.nextElement();
%>
	<%= name %>
<%
	}
%>
<p>
<b>request.getParameterMap() �޼ҵ� ���</b><br>
<%
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("name");
	if(nameParam != null) {
		
%>
name = <%= nameParam[0] %>
<%
	}
%>
</body>
</html>