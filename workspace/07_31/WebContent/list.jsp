<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "kr.ac.green.*" %>
<%@ page import = "java.util.*" %>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/test",
		"root",
		"1234"
	);
	
	String  sql = "SELECT * FROM car ORDER BY car_id DESC";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	//ResultSet 테이블 데이터를 저장하고 있는 객체
	
	Vector<Car> list = new Vector<Car>();
	
	while(rs.next()) {	//다음줄 있습니까 ? true로 리턴하고 한칸 이동함 
		int car_id = rs.getInt("car_id");
		String car_model = rs.getString("car_model");
		String car_desc = rs.getString("car_desc");
		int car_price = rs.getInt("car_price");
		
		Car car = new Car(car_id, car_model, car_price, car_desc);
		list.add(car);
	}
	//최대한 빨리 닫아줘야함 Vector에 다 담아 놨기 때문에 
	rs.close();
	stmt.close();
	con.close();
	
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<a href = "insert.jsp">insert car</a>
	<br>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>MODEL</th>
			<th>PRICE</th>
			<th>DESCRIPTION</th>
		</tr>
		<%
			if(list.size() == 0) {
		%>
		<tr>
			<td colspan = "4">empty</td>
		</tr>
		<%
			} else {
			for(Car temp : list) {
		%>
		<tr>
			<td><%=temp.getCar_id() %></td>
			<td><%=temp.getCar_model() %></td>
			<td><%=temp.getCar_price() %></td>
			<td><%=temp.getCar_desc() %></td>
		</tr>
		<% 
				}
			}
		%>
	</table>

</body>
</html>