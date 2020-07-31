<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!--WEB-INF 안의 lib안에 JDBC를 복사해서 넣어야 나중에 배포 할 때 제대로 동작함  -->
<!--톰켓 안의 lib안에 넣으면 안에서 실행은 되지만 배포할 때 는 안됨  -->

<%@ page import = "kr.ac.green.Car" %>
<%@ page import = "java.sql.*" %>
<jsp:useBean id ="car" class = "kr.ac.green.Car" />
<jsp:setProperty property = "*" name = "car" />
<%
	/*
		JDBC 프로그래밍 절차 
		1. 드라이버 로드 (한번만 해주면 된다 어플리케이션이 실행될 때 )
		2. 연결 -> java.sql.connection
		3. 질의 -> java.sql.Statement(CRUD)
		4. 연결해제 -- > 연결해제를 반드시 해줘야 함 !!!!
	*/
	
	// 1. 드라이버 로드 -> DriverManager에 등록 (어플리케이션이 실행될 때 1번만 실행하면 됨)
	Class.forName("com.mysql.jdbc.Driver");
	
	//2. 연결
	Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/test",//DB URL
		"root",//USER ID
		"1234"//USER PASSWORD
			
	);
	
	//3. 질의 담당 객체
	Statement stmt = con.createStatement();
	String sql = 
			"INSERT INTO car (car_model, car_price, car_desc)" +
			"VALUES ('" + car.getCar_model() + "' ,'" + car.getCar_price() + "','" + car.getCar_desc() + "');";
// 	String sql = "INSERT INTO car (car_model, car_price, car_desc)" + 
// 			"VALUES ('%s', '%d', '%s');";
// 			sql = String.format(
// 					sql, car.getCar_model(), car.getCar_price(), car.getCar_desc()); 
	
	/*
		executeUpdate(sql : String) : int -- > INSERT, UPDATE, DELETE 결과가 숫자로 돌아온다 레코드 수가 돌아옴
		(INSERT, UPDATE, DELETE)
		executeQuery(sql:String) :  ResultSet -- > SELECT 결과가 테이블로 돌아옴 
		(SELECT)
	*/
	int result = stmt.executeUpdate(sql);
	
	//4. 연결끊기
	stmt.close();
	con.close();
	//역순으로 끊어 줘야 함
		
	out.println(result + "행 삽입");
	
	response.sendRedirect("list.jsp");
%>