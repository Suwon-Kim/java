package com.jang.member;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlMemberDao implements IMemberDAO, IConstants_Member{

	private MySqlMemberDao(){
		try {    
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection connect(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, UID, UPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void disconnect(Connection con){
		try {
			con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	// 로그인 체크
	@Override
	public Member memberLogin(Connection con, HashMap<String, String> map) {
		Member member = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {   
			pStmt = con.prepareStatement(SQLS[LOGIN_CHECK]);
			pStmt.setString(1, map.get("mem_id"));
			pStmt.setString(2, map.get("mem_pw"));
			rs = pStmt.executeQuery();
			 
//			member = new Member(); 
			 
			if(rs.next()) {
				String mem_id = toKor(rs.getString("mem_id"));
				String mem_name = toKor(rs.getString("mem_name"));
				String mem_email = toKor(rs.getString("mem_email")); 
				member = new Member(mem_id, mem_name, mem_email);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{  
			close(rs);
			close(pStmt);
		}
		
		return member;
		
	}
	
	// 아이디 중복 확인
	@Override
	public int getCheckId(Connection con, String mem_id) {
		ResultSet rs = null;
		PreparedStatement pStmt = null;
		int ret = 0;
		try {   
			pStmt = con.prepareStatement(SQLS[CHECK_ID]);
			pStmt.setString(1, mem_id);
	
			rs = pStmt.executeQuery();
			
			if(rs.next()) {
				ret = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{  
			close(pStmt);
		}
		
		return ret;
		
	}
	
	@Override
	public int insertBoard(Connection con, Member member) {
		int result = 0;
		PreparedStatement pStmt = null;
		try {   
			pStmt = con.prepareStatement(SQLS[INSERT]);
			pStmt.setString(1, toEn(member.getMem_id()));
			pStmt.setString(2, toEn(member.getMem_name()));
			pStmt.setString(3, toEn(member.getMem_pw()));
			pStmt.setString(4, toEn(member.getMem_email()));
			pStmt.setString(5, toEn(member.getMem_reg()));
			result = pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{ 
			close(pStmt);
		}
		
		return result;
	}
	
	@Override
	public Member loginCheck(Connection con, Member member) {
		Member result = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			pStmt = con.prepareStatement(SQLS[LOGIN_CHECK]);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pStmt);
		}
		
		return result;
	}
	
	
	public String toKor(String en){
		String kor = null;

		try {
			kor = new String(en.getBytes("8859_1"), "euc_kr");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		 
		return kor;
	} 
	
	public String toEn(String kor){
		String en = null;

		try {
			en = new String(kor.getBytes("euc_kr"), "8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return en;
	}

	public void close(PreparedStatement pStmt){
		try {
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}





	
}
