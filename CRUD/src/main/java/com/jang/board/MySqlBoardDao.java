package com.jang.board;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlBoardDao implements IBoardDAO, IConstants{
	private MySqlBoardDao(){
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
		
	// 수정
		public int updateBoard(Connection con, Board board){
			int result = 0;
			PreparedStatement pStmt = null;
			try {
				pStmt = con.prepareStatement(SQLS[UPDATE]);
				pStmt.setString(1, toEn(board.getB_title()));
				pStmt.setString(2, toEn(board.getB_contents()));
				pStmt.setInt(3, board.getB_num());
				result = pStmt.executeUpdate();
			} catch (Exception e) {  
				e.printStackTrace();
			} finally{ 
				close(pStmt);
			}
			 
			return result;
		}
	
	// 삭제
	public int deleteBoard(Connection con, int num){
		int result = 0;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(SQLS[DELETE]);
			pStmt.setInt(1, num);
			result = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(pStmt);
		}
		
		
		return result;
	}
	
	// 개인 값 불러오기
		public Board getOne(Connection con, int num){
			Board list = null;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			try {
				pStmt = con.prepareStatement(SQLS[SELECT_ONE]);
				pStmt.setInt(1, num);
				rs = pStmt.executeQuery();
				
				list = new Board();
				
				if(rs.next()){
					int b_num = rs.getInt("b_num");
					String b_title = toKor(rs.getString("b_title"));
					String b_writer = toKor(rs.getString("b_writer"));
					String b_contents = toKor(rs.getString("b_contents"));
					byte[] filename1 = rs.getBytes("filename1");
					String b_reg = toKor(rs.getString("b_reg")); 
					int b_hit = rs.getInt("b_hit");
					list = new Board(b_num, b_title, b_writer, b_contents,filename1, b_reg, b_hit);
				}
				  
			} catch (Exception e) { 
				e.printStackTrace(); 
			} finally{
				close(rs);
				close(pStmt);
			}
			
			return list;
		}
	
	// 등록
		public int insertBoard(Connection con, Board board){
			int result = 0;
			PreparedStatement pStmt = null;
			try {  
				pStmt = con.prepareStatement(SQLS[INSERT]);
				pStmt.setString(1, toEn(board.getB_title()));
				pStmt.setString(2, toEn(board.getB_writer()));
				pStmt.setString(3, toEn(board.getB_contents()));
				pStmt.setString(4, toEn(board.getB_reg()));
				pStmt.setString(5, toEn(board.getB_id()));
				pStmt.setBytes(6, board.getFilename1());
				result = pStmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{ 
				close(pStmt);
			}
			
			return result; 
		}
		
		// 모든 목록
		public Board[] getAll(Connection con){
			Board[] list = null;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			   
			try {
				pStmt = con.prepareStatement(SQLS[SELECT]);
				rs = pStmt.executeQuery();
				
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				
				list = new Board[count]; 
				 
				int idx = 0;
				while(rs.next()){
					int b_num = rs.getInt("b_num");
					String b_title = toKor(rs.getString("b_title"));
					String b_writer = toKor(rs.getString("b_writer"));
					String b_contents = toKor(rs.getString("b_contents"));
					String b_reg = toKor(rs.getString("b_reg")); 
					int b_hit = rs.getInt("b_hit");
					 
					list[idx] = new Board(b_num, b_title, b_writer, b_contents, b_reg, b_hit);
					idx++;
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close(rs);
				close(pStmt);
			}
			
			return list;
		}
		
		// 검색
		public Board[] searchAll(Connection con, String option, String search_desc) {
			Board[] list = null;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			  
			try { 
				if(option.equals("b_num")){
					pStmt = con.prepareStatement(SQLS[SEARCH_NUM]);
					pStmt.setString(1, toEn("%"+search_desc+"%")); 
				}else if(option.equals("b_title")) {
					pStmt = con.prepareStatement(SQLS[SEARCH_TITLE]);
					pStmt.setString(1, toEn("%"+search_desc+"%"));
				}else if(option.equals("b_writer")) {	
					pStmt = con.prepareStatement(SQLS[SEARCH_WRITER]);
					pStmt.setString(1, toEn("%"+search_desc+"%"));  
				}else if(option.equals("all")) {	
					pStmt = con.prepareStatement(SQLS[SEARCH_ALL]);
					pStmt.setString(1, toEn("%"+search_desc+"%"));   
					pStmt.setString(2, toEn("%"+search_desc+"%"));   
					pStmt.setString(3, toEn("%"+search_desc+"%"));   
				}
				  
				rs = pStmt.executeQuery();
				
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				
				list = new Board[count];
				
				int idx = 0;
				while(rs.next()){ 
					int b_num = rs.getInt("b_num");
					String b_title = toKor(rs.getString("b_title"));
					String b_writer = toKor(rs.getString("b_writer"));
					String b_contents = toKor(rs.getString("b_contents"));
					String b_reg = toKor(rs.getString("b_reg"));
					int b_hit = rs.getInt("b_hit");
					
					list[idx] = new Board(b_num, b_title, b_writer, b_contents, b_reg, b_hit);
					idx++; 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs); 
				close(pStmt);
			}
			
			return list; 
		} 
		
		// 조회수 증가
		public int plusHit(Connection con, int num) {
			int result = 0;
			PreparedStatement pStmt = null;
			try {    
				pStmt = con.prepareStatement(SQLS[PLUS_HIT]);
				pStmt.setInt(1, num);  
				result = pStmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally{ 
				close(pStmt);
			}
			
			return result;
		}
		
		// 전체 게시물 개수
		@Override
		public int getTotalCount(Connection con) {
			int count = 0;
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			try {
				pStmt = con.prepareStatement(SQLS[TOTAL_COUNT]);
				rs = pStmt.executeQuery();
				if(rs.next())count = rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pStmt);
			}
			
			return count;
		}
		
		// 페이징용
		// 페이징 하는이유 : 응답속도 향상, 서버쪽 부하 감소
		@Override
		public Board[] getList(Connection con, int pageNum, int docsPerPage) {
			Board[] list = null; 
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			try {
				pStmt = con.prepareStatement(SQLS[PAGING_LIST]);
				// pageNum : 현재 페이지 번호
				// docsPerPage : 페이지당 보여줄 개수
				pStmt.setInt(1, (pageNum - 1) * docsPerPage);
				pStmt.setInt(2,  docsPerPage);
				rs = pStmt.executeQuery();
				
				rs.last();
				int count = rs.getRow();
				rs.beforeFirst();
				
				list = new Board[count]; 
				 
				int idx = 0;
				while(rs.next()){
					int b_num = rs.getInt("b_num");
					String b_title = toKor(rs.getString("b_title"));
					String b_writer = toKor(rs.getString("b_writer"));
					String b_contents = toKor(rs.getString("b_contents"));
					String b_reg = toKor(rs.getString("b_reg")); 
					int b_hit = rs.getInt("b_hit");
					 
					list[idx] = new Board(b_num, b_title, b_writer, b_contents, b_reg, b_hit);
					idx++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close(rs);
				close(pStmt);
			}
			
			return list;
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
