<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통계</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<style>
	.mycontainer {
		margin: 0px auto;
		padding: 30px; 
		width: 1000px;
		height :700px;
		border: 1px solid #cccccc;
		background-color: WHITE;
	}
	 
     th,td { 
        text-align: center; 
     }

</style>
</head>
<style>
	.mycontainer {
		margin: 0px auto;
		padding: 30px; 
		width: 1000px;
		height :600px;
		border: 1px solid #cccccc;
		background-color: WHITE;
		margin-bottom : 99px;
	}
	 
     th,td {
        text-align: center;
     }
 
</style>
<body> 
  	<jsp:include page="menu.jsp" />
  		<h2 align="center" style="margin-top: 40px; margin-bottom: 40px">통계게시판</h2> 
	<div class="mycontainer">
		
	</div>
</body>
</html> 

<jsp:include page="footer.jsp" />