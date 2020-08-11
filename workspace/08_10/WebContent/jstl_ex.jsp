<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jstl_ex.jsp</title>
</head>
<body>
<%
	int num = 3; // ��������(�Ӽ�X)
	// pageContext.setAttribute("num", 100);
%>
<%-- ����(�Ӽ�) ���� --%>
<c:set var="num" value="100" />
<%-- ����(�Ӽ�) ���� --%>
<c:remove var="num" />
${ num }
<%-- ���ǹ� --%>
<c:if test="${ 10 > 5 }">
	hi~
</c:if>
<c:choose>
	<c:when test="${num <  50}"> 50���� �����ϴ�  </c:when>
	<c:when test="${num >  50}"> 50���� Ů�ϴ�  </c:when>
	<c:otherwise>Ů�ϴ�</c:otherwise>
</c:choose>
<br>
<c:forEach var = "i" begin = "0" end = "10" step = "3"> <%-- �������� ������ --%>
${ i }<br>
</c:forEach>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");
	list.add("f");
	
	pageContext.setAttribute("list", list); //���������̹Ƿ� list�� setAttribute ��
%>
<br>
<c:forEach var = "word" items = "${ list }">
	${ word }
</c:forEach>
<c:forEach var = "num" begin = "0" end = "5" varStatus = "status">
	begin : ${ status.begin }<br>
	end : ${ status.end }<br>
	current : ${ status.current }<br>
	count : ${ status.count }<br>
</c:forEach>
</body>
</html>