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
			out.println("햄버거를 주문하셨습니다.");
		}
		
		if(values[i].equals("1500")) {
			out.println("콜라를 주문하셨습니다.");
		}

		if(values[i].equals("2000")) {
			out.println("감자튀김을 주문하셨습니다");
		}
	
		if(values[i].equals("2500")) {
			out.println("샐러드를 주문하셨습니다.");
		}
		result = result + Integer.parseInt(values[i]);
%>				
	<br>	
<%
		}
	}

%>
당신의 총 주문 금액은 : <%= result + "원입니다." %>
<br>
<br>
<br>
<a href = "menu.jsp">
메뉴로 가기
</a>


</body>
</html>