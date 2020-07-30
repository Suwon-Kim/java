<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.Vector"%>
<%@ page import="kr.ac.green.Article"%>

<%--
	번호, 제목, 내용, 글쓴이, 작성일, 비밀번호
--%>

<html>
<head>
<title>list.jsp</title>
<body>
	<%
		//String msg = "어서오세요";
		//Object o = session.getAttribute("msg");
		//if(o != null) {
		//	msg = o.toString();
		//}
	%>
	<a href = "write.jsp">글 등록</a>
	<hr>
	<table border = "2">
		<tr>
			<th>글 번호&nbsp;</th>
			<th>글 제목&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
			<th>글쓴이&nbsp;&nbsp;&nbsp;</th>
			<th>작성일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
		</tr>
		<%
			Vector<Article> list = (Vector<Article>) application.getAttribute("list");
			if(list == null || list.size() == 0) {
			
		%>
		<tr>
			<th colspan = "4">등록된 글이 없습니다</th>
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