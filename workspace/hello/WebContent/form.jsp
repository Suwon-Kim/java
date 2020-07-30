<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>폼 생성</title>
</head>
<body>
<!-- name = 백다원
	 address = 부산
	 pet = dog
	 pet = cat -->
<form action = "viewParameter.jsp" method = get>
이름 : <input type = "text" name = "name" size = "10"><br>
주소 : <input type = "text" name = "address" size = "30"><br>
좋아하는 동물 :
	<input type = "checkbox" name = "pet" value = "dog">강아지
	<input type = "checkbox" name = "pet" value = "cat">고양이
	<input type = "checkbox" name = "pet" value = "pig">돼지
<br>
<input type = "submit" value = "전송">
</form>
</body>
</html>

<!-- get방식과 post 방식 
get방식 : 파라미터가 보이는 방식 언제 쓰는지 ? -- > 
http://localhost:8080/hello/viewParameter.jsp?name=abc&address=qwer&pet=dog&pet=cat
2번이상 연속해서 작업을 해도 상관없는 일 할 때는 get으로 표현

읽기는 get방식으로 처리 
노출이 되도 상관없음
post방식 : 파라미터가 보이지 않는 방식 언제 쓰는지 ? -- > 
http://localhost:8080/hello/viewParameter.jsp
여러번 수행하면 안되는 일(read) post방식으로 처리 
서버 측에 변경이 되는일 (create, update, delete)은 전부 post방식으로 처리 
노출이 되면 안됨 
 -->