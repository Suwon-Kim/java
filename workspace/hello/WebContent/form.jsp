<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>�� ����</title>
</head>
<body>
<!-- name = ��ٿ�
	 address = �λ�
	 pet = dog
	 pet = cat -->
<form action = "viewParameter.jsp" method = get>
�̸� : <input type = "text" name = "name" size = "10"><br>
�ּ� : <input type = "text" name = "address" size = "30"><br>
�����ϴ� ���� :
	<input type = "checkbox" name = "pet" value = "dog">������
	<input type = "checkbox" name = "pet" value = "cat">�����
	<input type = "checkbox" name = "pet" value = "pig">����
<br>
<input type = "submit" value = "����">
</form>
</body>
</html>

<!-- get��İ� post ��� 
get��� : �Ķ���Ͱ� ���̴� ��� ���� ������ ? -- > 
http://localhost:8080/hello/viewParameter.jsp?name=abc&address=qwer&pet=dog&pet=cat
2���̻� �����ؼ� �۾��� �ص� ������� �� �� ���� get���� ǥ��

�б�� get������� ó�� 
������ �ǵ� �������
post��� : �Ķ���Ͱ� ������ �ʴ� ��� ���� ������ ? -- > 
http://localhost:8080/hello/viewParameter.jsp
������ �����ϸ� �ȵǴ� ��(read) post������� ó�� 
���� ���� ������ �Ǵ��� (create, update, delete)�� ���� post������� ó�� 
������ �Ǹ� �ȵ� 
 -->