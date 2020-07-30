<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function checkInput(){
		var inputValue = document.myForm.some.value;
		
		if(inputValue.trim().length == 0){
			alert("입력해라");
		}else{
			alert("잘했어~");
		}
		 
		alert(inputValue);
	}
</script>
</head>
<body>
	<form name="myForm">
		<input type="text" name="some" />
		<input type="button" value="check" onclick="checkInput()" />
	</form>
</body>
</html>