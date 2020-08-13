package org.green.crudEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;


@Repository
public class MySqlCarDao implements ICarDAO {
	public MySqlCarDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Connection connect() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test", 
				"root", 
				"1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public void disconnect(Connection con) {
		try {
			con.close();
		} catch(Exception e) {}
	}

	@Override
	public int insertCar(Connection con, Car car) {
		int result = 0;
		String sql = 
			"INSERT INTO  car (car_model, car_price, car_desc) VALUES(?,?,?)";
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, car.getCar_model());
			pStmt.setInt(2, car.getCar_price());
			pStmt.setString(3, car.getCar_desc());
			
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pStmt);
		}
		return result;
	}

	@Override
	public Car[] getAll(Connection con) {
		Car[] list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM car ORDER BY car_id DESC";
		
		try {
			pStmt = con.prepareStatement(sql);
			rs = pStmt.executeQuery();
			rs.last();
			list = new Car[rs.getRow()];
			rs.beforeFirst();
			int idx = 0;
			while(rs.next()) {
				list[idx] = new Car(
					rs.getInt("car_id"),
					rs.getString("car_model"),
					rs.getInt("car_price"),
					rs.getString("car_desc")
				);
				idx++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		
		
		return list;
	}
	
	private void close(Statement stmt) {
		try {
			stmt.close();
		} catch(Exception e) {}
	}
	private void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {}
	}

}
