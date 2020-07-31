<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!--WEB-INF ���� lib�ȿ� JDBC�� �����ؼ� �־�� ���߿� ���� �� �� ����� ������  -->
<!--���� ���� lib�ȿ� ������ �ȿ��� ������ ������ ������ �� �� �ȵ�  -->

<%@ page import = "kr.ac.green.Car" %>
<%@ page import = "java.sql.*" %>
<jsp:useBean id ="car" class = "kr.ac.green.Car" />
<jsp:setProperty property = "*" name = "car" />
<%
	/*
		JDBC ���α׷��� ���� 
		1. ����̹� �ε� (�ѹ��� ���ָ� �ȴ� ���ø����̼��� ����� �� )
		2. ���� -> java.sql.connection
		3. ���� -> java.sql.Statement(CRUD)
		4. �������� -- > ���������� �ݵ�� ����� �� !!!!
	*/
	
	// 1. ����̹� �ε� -> DriverManager�� ��� (���ø����̼��� ����� �� 1���� �����ϸ� ��)
	Class.forName("com.mysql.jdbc.Driver");
	
	//2. ����
	Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/test",//DB URL
		"root",//USER ID
		"1234"//USER PASSWORD
			
	);
	
	//3. ���� ��� ��ü
	Statement stmt = con.createStatement();
	String sql = 
			"INSERT INTO car (car_model, car_price, car_desc)" +
			"VALUES ('" + car.getCar_model() + "' ,'" + car.getCar_price() + "','" + car.getCar_desc() + "');";
// 	String sql = "INSERT INTO car (car_model, car_price, car_desc)" + 
// 			"VALUES ('%s', '%d', '%s');";
// 			sql = String.format(
// 					sql, car.getCar_model(), car.getCar_price(), car.getCar_desc()); 
	
	/*
		executeUpdate(sql : String) : int -- > INSERT, UPDATE, DELETE ����� ���ڷ� ���ƿ´� ���ڵ� ���� ���ƿ�
		(INSERT, UPDATE, DELETE)
		executeQuery(sql:String) :  ResultSet -- > SELECT ����� ���̺�� ���ƿ� 
		(SELECT)
	*/
	int result = stmt.executeUpdate(sql);
	
	//4. �������
	stmt.close();
	con.close();
	//�������� ���� ��� ��
		
	out.println(result + "�� ����");
	
	response.sendRedirect("list.jsp");
%>