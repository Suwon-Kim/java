package kr.ac.green;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

interface Constants {
	String DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/test";
	String UID = "root";
	String UPW = "1234";
	
	String[] SQLS = {
		"INSERT INTO car (car_model, car_price, car_desc) VALUES (?, ?, ?)",
		"SELECT * FROM car ORDER BY car_id DESC",
		"DELETE FROM car"
	};
	
	int INSERT = 0;
	int GET_ALL = 1;
	int CLEAR = 2;
}
public class AdvancedCarDao implements Constants{
	
	private AdvancedCarDao() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static final AdvancedCarDao dao = new AdvancedCarDao();
	
	public static AdvancedCarDao getDao() {
		return dao;
	}
	
	public Connection connect() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(DB_URL, UID, UPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void disconnect(Connection con) {
		try {
			con.close();
		} catch (Exception e) {}
	}
	
	public int insertCar(Connection con, Car car) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[INSERT]);
			pStmt.setString(1, car.getCar_model());
			pStmt.setInt(2, car.getCar_price());
			pStmt.setString(3, car.getCar_desc());
			result = pStmt.executeUpdate();			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pStmt.clearParameters();
				pStmt.close();
			} catch(Exception e) {}
		}		
		return result;
	}
	
	public Car[] getAll(Connection con) {
		Car[] list = null;
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(SQLS[GET_ALL]);
			rs = pStmt.executeQuery();
			
			rs.last();
			int count = rs.getRow();
			rs.beforeFirst();
			
			list = new Car[count];
			int idx = 0;
			while(rs.next()) {
				String model = rs.getString("car_model");
				int id = rs.getInt("car_id");
				String desc = rs.getString("car_desc");
				int price = rs.getInt("car_price");
				
				list[idx] = new Car(id, model, price, desc);
				idx++;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch(Exception e) {}
			try {
				pStmt.close();
			} catch(Exception e) {}
		}		
		return list;
	}
	
	public int clear(Connection con) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[CLEAR]);
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pStmt.close();
			} catch(Exception e) {
				
			}
		}
	
		return result;
	}
	
}





