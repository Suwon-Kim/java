<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Enumeration" %>
<%@ page import = "java.util.Map" %>
<%
	//파라미터의 인코딩을 성절함 (POST 방식) 대상은 requestBody에 해당됨
	//get방식으로 한글을 전송하면 꺼내 올 수 없다
	request.setCharacterEncoding("utf-8"); // <<< post방식일때만 사용 할 수 있다.
	//request의 파라미터 접근하기 전에 반드시 적어줘야 한다.  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>요청 파라미터 출력</title>
</head>
<body>
<b>request.getParameter() 메소드 사용</b><br>
name 파라미터 = <%= request.getParameter("name") %><br>
address 파라미터 = <%= request.getParameter("address") %>
<p>
<b>request.getParameterValues() 메소드 사용</b><br>
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
<b>request.getParameterNames() 메서드 사용</b>
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
<b>request.getParameterMap() 메소드 사용</b><br>
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