<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.Vector" %>
<%@ page import = "kr.ac.green.Article" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	Vector<Article> list = (Vector<Article>) application.getAttribute("list");
	Article article = list.get(list.indexOf(new Article(num)));	
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content = "text/html"; charset = EUC-KR">
<title>readArticle</title>
</head>
<body>
	<%= request.getParameter("num") %>
	
	<form id = "modifyForm " method = "post">
		번호 : <input type = "text" name = "num" value = "<%= article.getNum() %>" readonly = "readonly" />
		<br>
		글 제목 : <input type = "text" name = "title" value = "<%= article.getTitle() %>" />
		<br>
		글쓴이 : <input type = "text" name = "writer" value = "<%= article.getWriter() %>" readonly = "readonly" />
		<br>
		작성일 : <input type = "text" name = "date" value = "<%= article.getDateString() %>" readonly = "readonly" />
		<br>
		비밀번호 : <input type = "password" name = "pw" />
		<br>
		<textarea name = "contents" rows = "5" cols = "50"><%= article.getContents() %></textarea>
		<br>
		<input type = "button" value = "목록보기" onclick = "goList()" />
		<input type = "button" value = "수정" onclick = "todo('update')" />
		<input type = "button" value = "삭제" onclick = "todo('delete')" />
		<input type = "reset" />
	</form>
		<script>
			function goList() {
				location.href = "list.jsp";	
			}
			function todo() {
				var what = arguments[0];
				
				var modifyForm = document.getElementById("modifyForm");
				modifyForm.action = what + ".jsp";
				
				modifyForm.submit();
			}
		</script>
</body>
</html>
