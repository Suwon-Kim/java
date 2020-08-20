	<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
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

</style>   
</head> 
<body>
	<jsp:include page="menu.jsp" />
			<h2 align="center" style="margin-top: 40px; margin-bottom: 40px">메인페이지</h2> 
		<div class="mycontainer">
			<div >
				<img src="resources/images/b.png" style="width:940px; height:540px;" />
			</div> 
		</div> 
	<jsp:include page="footer.jsp" />
</body>
</html>