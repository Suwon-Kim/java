<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>

<body> 
	<jsp:include page="menu.jsp" />
	<form action="login_check" method="post">
	<div class="container" align="center">
		<div align="left"
			style="padding: 30px; width: 500px; border: 1px solid #cccccc; background-color: WHITE; margin-bottom : 99px;">
			<h3>로그인</h3>
			<hr />

			<div class="form-inline">
				<label style="width: 80px">아이디</label> 
				<input type="text" class="form-control" id="mem_id" name="mem_id" placeholder="아이디를 입력하세요." /> 
			</div>

			<div class="form-inline" style="margin-top: 5px">
				<label style="width: 80px">암호</label> 
				<input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="암호를 입력하세요." />
			</div>

			<hr />

			<div align="center">
				<input type="submit" class="btn btn-success" id="btn_login" value="로그인" /> 
				<a href="joinForm" ><input type="button" class="btn btn-primary" value="회원가입" /></a>
			</div>
		</div>
	</div>
	</form>
	<jsp:include page="footer.jsp" />
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
  <script type="text/javascript">
$(document).ready(function(){
	
	//id="btn_join"인 태그를 찾아서 클릭되면
	$('#btn_login').click(function(){
		var id = $('#mem_id').val();
		if(id == ''){
		alert('아이디를 입력하세요.');
		$('#mem_id').focus(); //이름 입력칸으로 focus이동함.
		return false; //servlet로 값을 전달하지 않음.
	}
		var pw = $('#mem_pw').val();
		if(pw == ''){
		alert('비밀번호를 입력하세요.');
		$('#mem_pw').focus(); //이름 입력칸으로 focus이동함.
		return false; //servlet로 값을 전달하지 않음.
	}

	});
});	
</script>

</html>






