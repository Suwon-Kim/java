<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>template.jsp</title>
</head>
<%
	// contents 들고옴
	String contents = request.getParameter("contents");
	// 없을 경우
	String contentsPage = "contentsA";
	// 있을 경우
	if(contents != null){
		contentsPage = contents;
	}
	contentsPage += ".jsp";
%>
<body>
	<table border="1" width="80%">
		<tr>
			<td colspan="2">
				<!-- logo.jsp -->
				<jsp:include page="logo.jsp" />
			</td>
		</tr>
		<tr>
			<td width="30%">
				<!-- menu.jsp -->
				<jsp:include page="menu.jsp" />
			</td>
			<td>
				<!-- contents.jsp -->
				<jsp:include page="<%= contentsPage %>"/>
			</td>	
		</tr>
	</table>
</body>