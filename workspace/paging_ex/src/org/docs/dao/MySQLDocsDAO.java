package org.docs.dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.docs.beans.Doc;

public class MySQLDocsDAO implements IDAO, MySQLConstant {
	private static MySQLDocsDAO dao = new MySQLDocsDAO();
	
	private MySQLDocsDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLDocsDAO getInstance() {
		return dao;
	}
	@Override
	public Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DBURL, UID, UPW);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void disconnect(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) { }
	}
	
	private void disconnect(PreparedStatement pStmt) {
		try {
			if(pStmt != null) {
				pStmt.close();
			}
		} catch(SQLException e) { }
	}
	@Override
	public void disconnect(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		} catch(SQLException e) { }
	}
	
	@Override
	public int writeDoc(Connection con, Doc doc) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[WRITE]);
			
			pStmt.setString(1, toEn(doc.getD_title()));
			pStmt.setString(2, toEn(doc.getD_author()));
			pStmt.setString(3, toEn(doc.getD_content()));
			pStmt.setString(4,  toEn(doc.getD_date()));
			
			result = pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(pStmt);
		}
		return result;
	}
	@Override
	public int updateDoc(Connection con, Doc doc) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[UPDATE]);
			pStmt.setString(1,  toEn(doc.getD_title()));
			pStmt.setString(2, toEn(doc.getD_content()));
			pStmt.setString(3,  toEn(doc.getD_author()));
			pStmt.setString(4, toEn(doc.getD_date()));
			pStmt.setInt(5, doc.getD_num());
			
			result = pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(pStmt);
		}
		return result;
	}
	@Override
	public Doc[] getAll(Connection con) {
		Doc[] list = null;
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[GETALL]);
			rs = pStmt.executeQuery();
			ArrayList<Doc> arr = new ArrayList<Doc>();
			
			while(rs.next()) {
				arr.add(getDoc(rs));
			}
			list = arr.toArray(new Doc[0]);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(rs);
			disconnect(pStmt);
		}
		return list;
	}
	private Doc getDoc(ResultSet rs) throws SQLException {
		Doc doc = new Doc(
			rs.getInt(1),
			toKor(rs.getString(2)),
			toKor(rs.getString(3)),
			toKor(rs.getString(4)),
			toKor(rs.getString(5))				
		);	//첫번째 콜럼 두번째 콜럼 ~ 5번째 콜럼
		return doc;
	}
	
	@Override
	public Doc getDocByID(Connection con, int d_num) {
		Doc doc = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[FIND]);
			pStmt.setInt(1,  d_num);
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				doc = getDoc(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(rs);
			disconnect(pStmt);
		}
		return doc;
	}
	@Override
	public Doc[] getList(Connection con, int pageNum, int docsPerPage) {
		Doc[] list = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[LIST]);
			pStmt.setInt(1, (pageNum - 1) * docsPerPage);
			pStmt.setInt(2, docsPerPage);
			rs = pStmt.executeQuery();
			ArrayList<Doc> arr = new ArrayList<Doc>();
			while(rs.next()) {
				arr.add(getDoc(rs));
			}
			list = arr.toArray(new Doc[0]);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(rs);
			disconnect(pStmt);
		}
		return list;
	}
	@Override
	public int getTotalCount(Connection con) {
		int count = 0;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[COUNT]);
			rs = pStmt.executeQuery();
			if(rs.next())count = rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(rs);
			disconnect(pStmt);
		}
		return count;
	}
	
	public static String toEn(String str) {
		try {
			str = new String(str.getBytes("euc_kr"), "8859_1");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String toKor(String str) {
		try {
			str = new String(str.getBytes("8859_1"), "euc_kr");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public int deleteDoc(Connection con, int d_num) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[DELETE]);
			pStmt.setInt(1, d_num);
			result = pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(pStmt);
		}
		return result;
	}
	
}
