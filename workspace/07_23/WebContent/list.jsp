<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Vector"%>
<%@ page import="kr.ac.green.Article"%>

<%--
	��ȣ, ����, ����, �۾���, �ۼ���, ��й�ȣ
--%>

<html>
<head>
<title>list.jsp</title>
<body>
	<%
		//String msg = "�������";
		//Object o = session.getAttribute("msg");
		//if(o != null) {
		//	msg = o.toString();
		//}
	%>
	<a href = "write.jsp">�� ���</a>
	<hr>
	<table border = "2">
		<tr>
			<th>�� ��ȣ&nbsp;</th>
			<th>�� ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>�۾���&nbsp;&nbsp;&nbsp;</th>
			<th>�ۼ���&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		</tr>
		<%
			Vector<Article> list = (Vector<Article>) application.getAttribute("list");
			if(list == null || list.size() == 0) {
			
		%>
		<tr>
			<th colspan = "4">��ϵ� ���� �����ϴ�</th>
		</tr>
		<%
			} else {
				for(int i = list.size() - 1; i >= 0; i--) {
					Article temp = list.get(i);
		%>
		<tr onclick = "select(<%=temp.getNum() %>)">
			<td><%= temp.getNum() %></td>
			<td><%= temp.getTitle() %></td>
			<td><%= temp.getWriter() %></td>
			<td><%= temp.getDateString() %></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<form id = "hiddenForm" name = "hiddenForm" action = "readArticle.jsp">
		
	</form>


</body>
</head>
</html>