<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


<%
	int result = 0;
	String[] values = request.getParameterValues("menu");
	if(values != null) {
		for(int i = 0; i < values.length; i++) {
	
		if(values[i].equals("5000")) {
			out.println("�ܹ��Ÿ� �ֹ��ϼ̽��ϴ�.");
		}
		
		if(values[i].equals("1500")) {
			out.println("�ݶ� �ֹ��ϼ̽��ϴ�.");
		}

		if(values[i].equals("2000")) {
			out.println("����Ƣ���� �ֹ��ϼ̽��ϴ�");
		}
	
		if(values[i].equals("2500")) {
			out.println("�����带 �ֹ��ϼ̽��ϴ�.");
		}
		result = result + Integer.parseInt(values[i]);
%>				
	<br>	
<%
		}
	}

%>
����� �� �ֹ� �ݾ��� : <%= result + "���Դϴ�." %>
<br>
<br>
<br>
<a href = "menu.jsp">
�޴��� ����
</a>


</body>
</html>