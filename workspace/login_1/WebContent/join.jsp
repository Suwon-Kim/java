<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%@ page import = "kr.ac.green.JoinInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>join.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script>
	function join_form() {
		var inputId = document.joinForm.u_id.value;
		var inputPw = document.joinForm.u_pw.value;
		var inputRe = document.joinForm.u_re.value;
		var inputName = document.joinForm.u_name.value;
		var inputNick = document.joinForm.u_nick.value;
		
		if(inputId.trim().length == 0) {
			alert("���̵� �Է����ּ��� (���� X)");
		} else if(inputPw.trim().length == 0 ) {
			alert("��й�ȣ�� �Է����ּ��� (���� X)")
		} else if(inputRe.trim().length == 0 ) {
			alert("RE��й�ȣ�� �Է����ּ��� (���� X)") 
		} else if(inputName.trim().length == 0) {
			alert("�̸��� �Է����ּ��� (����X)")
		} else if(inputNick.trim().length == 0) {
			alert("�г����� �Է����ּ��� (���� X)")
		} else if(!(inputRe == inputPw)) {
			alert("��й�ȣ�� Ʋ���ϴ� .");
		} else {
			var joinForm = document.getElementById("joinFormId");
			joinForm.action = "dispose.jsp";
			joinForm.submit();
		}
	}
</script>
</head>
<body>	
	<p class="titleStr">
		Join Member
	</p>
	<form name="joinForm" id="joinFormId" method = "post">
		<div class="centerBox" >
			<label for="u_id">ID :</label> <input type="text" name="u_id" /><br/>
			<label for="u_pw">PW :</label> <input type="password" name="u_pw" /><br/>
			<label for="u_re">Retry :</label> <input type="password" name="u_re" /><br/>
			<label for="u_name">Name :</label> <input type="text" name="u_name" /><br/>
			<label for="u_nick">Nick :</label> <input type="text" name="u_nick" /><br/>				
			<div class="btns">
				<input type="button" value="ȸ������" onclick = "join_form()" />
				<input type="button" value="���" />		
			</div>
		</div>
		<div class="msgBox" id="msg">
			put message, here
		</div>	
	</form>	
</body>
</html>