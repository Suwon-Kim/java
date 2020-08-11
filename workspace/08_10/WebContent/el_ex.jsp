<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>EL(Expression Language)</title>
</head>
<body>
	<!-- el_ex.jsp -->
	<%--
		pageScope
		requestScope
		sessionScope
		applicationScope
	--%>
	${ empty emptyArr }
	<hr>
	<%= 1 + 2 + 3 %> : ${ 1 + 2 + 3 } : ${ 10 > 11 }
	<hr>
	${ map["key2"] } : ${ map.key2 }
	<hr>
	${ list[1] }
	<hr>
	���� parameter : <%= request.getParameter("paramName") %> : 
	<%= request.getParameter("paramSome") %>
	<br>
	EL parameter : ${ param.paramName }	 : ${ param.paramSome }
	<hr>	
	������� : <%= request.getAttribute("some").toString() %>
	: <%= session.getAttribute("yourName").toString() %>
	: <%= application.getAttribute("myName") %>
	
	<br>
	EL : ${ requestScope.some } : ${ sessionScope.yourName } : ${ applicationScope.myName }
	: ${ requestScope.dummy.num } : ${ requestScope.dummy.title }
	: ${ requestScope.arr[2] }
	<br>
	EL other : ${ some } : ${ yourName } : ${ myName }  
	: ${ dummy["num"] } : ${ dummy.title } : ${ arr[2] }
	<%-- pageScope, requestScope, sessionScope, applicationScope �� ã�ƺ� �ڵ�����--%>	
	<%-- ǥ������ �׷��� �ڸ��� $�� �� �� �� ���� --%>
	<%-- EL�� �����°� �ִµ� ��Ƴִ°� ����  --%>
	<%-- https://mvnrepository.com/ --%> <%--���� ���Ե� ������ maven --%>
	<%-- JSTL(JAVA Standard tag library) �˻� --%>
</body>
</html>



