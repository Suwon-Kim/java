<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function checkInput() {
		var inputId = document.myForm.some.value;
		
		if(inputValue.trim().length == 0) {
			alert("�Է��ض�");
			console.log("�Է��ض�");
		} else {
			alert("���߾�");
			console.log("�Է��ض�");
		}
		
		
	}
</script>
</head>
<body>
	<form name = "myForm">
		<input type = "text" name = "some" />
		<input type = "button" value = "check" onclick = "checkInput()" />
	</form>
</body>
</html>