<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.green.Dummy" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>forward.jsp</title>
</head>
<body>
	<%
		request.setAttribute("emptyArr", new Vector().toArray());
	
		Dummy d = new Dummy();
		d.setNum(100);
		d.setTitle("newTitle");
		
		Map<String, String> map = new Hashtable<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value4");
		
		request.setAttribute("map", map);
		
		
		Vector<String> list = new Vector<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		request.setAttribute("list", list);
		request.setAttribute("arr", new int[] {1,2,3});
		request.setAttribute("dummy", d);
		request.setAttribute("some", "other");
		session.setAttribute("yourName", "james");
	%>
	<jsp:forward page="el_ex.jsp" >
		<jsp:param value="paramValue" name="paramName"/>
	</jsp:forward>
	
</body>
</html>







