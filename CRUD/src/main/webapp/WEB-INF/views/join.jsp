<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="menu.jsp" />  
	<form action="insertJoin" method="post">
		<div class="container" align="center">
			<div align="left"
				style="width: 500px; border: 1px solid #eeeeee; padding: 20px; background-color: WHITE; margin-bottom : 99px;">
				<h3>회원가입</h3>
				<hr />

				<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">아이디</label> 
					<input type="text" id="mem_id" name="mem_id" style="width: 240px" class="form-control" placeholder="아이디 입력" required/> 
					<label id="output" style="color:light-gray;">중복확인</label>
<!-- 					<a href="joinCheck"><input type="button" style="width: 80px" class="btn btn-info btn-sm" value="중복확인"></a> -->
				</div>
  
 				<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">암호</label> <input type="password" id="mem_pw"
						name="mem_pw" style="width: 300px" class="form-control"
						placeholder="암호 입력" required />
				</div>
 
				<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">암호 재입력</label> <input type="password" id="mem_pw1"
						style="width: 300px" class="form-control"
						placeholder="암호 재입력" required />
				</div>
 
				<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">이름</label> <input type="text" id="mem_name"
						name="mem_name" style="width: 300px" class="form-control"
						placeholder="이름 입력" required />
				</div>

				<div class="form-inline" style="margin-bottom: 5px">
					<label style="width: 120px">이메일</label> 
					<input type="text" id="mem_email" name="mem_email" style="width: 300px" class="form-control" placeholder="이메일 입력" required />
				</div>

				<hr />

				<div class="form-inline" style="margin-bottom: 10px" align="center">
					<input type="submit" id="btn_join" class="btn btn-success" value="회원가입" /> 
					<a href="home" ><input type="button" class="btn btn-primary" value="뒤로가기" /></a>
				</div>
 
			</div>
		</div>
	</form>
	<jsp:include page="footer.jsp" />
	
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//id="btn_join"인 태그를 찾아서 클릭되면
		$('#btn_join').click(function(){
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
			var pwd = $('#mem_pw1').val();
			if(pwd == ''){
			alert('비밀번호를 다시 입력하세요.');
			$('#mem_pw1').focus(); //이름 입력칸으로 focus이동함.
			return false; //servlet로 값을 전달하지 않음.
		}
			var na = $('#mem_name').val();
			if(na == ''){
			alert('이름을 입력하세요.');
			$('#mem_name').focus(); //이름 입력칸으로 focus이동함.
			return false; //servlet로 값을 전달하지 않음.
		}
			var em = $('#mem_email').val();
			if(em == ''){
			alert('이메일을 입력하세요.');
			$('#mem_email').focus(); //이름 입력칸으로 focus이동함.
			return false; //servlet로 값을 전달하지 않음.
		}
			
			var pw = $('#mem_pw').val();
			var pw1 = $('#mem_pw1').val();
			if(pw != pw1){
				alert('비밀번호가 맞지 않습니다.');
				$('#mem_pw').focus(); //이름 입력칸으로 focus이동함.
			return false; //servlet로 값을 전달하지 않음.
			}
		});
		
		$('#mem_id').keyup(function(){
			var a = $('#mem_id').val();
			if(a.length > 0){
			$.post("app_checkid", {"mem_id": a }, function(data){
					//{"ret":"y"} or {"ret": "n"}	
				if(data.ret == 'y'){
						$('#output').html('<font color="red">사용불가</font>');
					}
				else if(data.ret == 'n'){
						$('#output').html('<font color="blue">사용가능</font>');
					}	
				}, "json");
			} 
			else{
				$('#output').text('중복확인');
			}
		});
		
	});	
</script>
</body>

</html>