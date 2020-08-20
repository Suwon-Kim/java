<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head> 
  
<body>
	<jsp:include page="menu.jsp" />

	<div class="container" style="background-color: white;">
		<div class="row">
<!-- 			<div class="col-md-12"> -->
<!-- 				<img src="imgs/green.jpg" width="1150px" height="350px" -->
<!-- 					style="padding: 30px;" /> -->
<!-- 			</div> -->
		</div>
		<!-- 		<div class="row" style="margin-top: 10px; padding: 50px"> -->
		<!-- 			<div class="col-md-5"> -->
		<!-- 				<img src="imgs/girl2.jpg" style="width: 450px; height: 300px;" /> -->
		<!-- 			</div> -->
		<!-- 			<div class="col-md-5"> -->
		<!-- 				<img src="imgs/girl3.jpg" style="width: 600px; height: 300px;" /> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
   
	</div>
			<h2 align="center" style="margin-bottom: 40px">자유게시판</h2>
	<jsp:include page="board.jsp" /> 

	<jsp:include page="footer.jsp" />
</body>
</html>