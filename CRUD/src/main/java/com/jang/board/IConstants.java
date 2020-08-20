package com.jang.board;

public interface IConstants {
	String DRIVER = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/test";
	  
	String UID = "root"; 
	String UPW = "1234";  
	  
	String[] SQLS = {
		"INSERT INTO board (b_title, b_writer, b_contents, b_reg, b_id, filename1) VALUES (?,?,?,?,?,?)",
		"SELECT * FROM board ORDER BY b_num DESC", 
		"UPDATE board SET b_title = ?, b_contents = ? WHERE b_num = ?",
		"DELETE FROM board WHERE b_num = ?",  
		"SELECT * FROM board WHERE b_num = ?", 
		"SELECT * FROM board WHERE b_num LIKE ? ORDER BY b_num DESC",
		"SELECT * FROM board WHERE b_title LIKE ? ORDER BY b_num DESC",
		"SELECT * FROM board WHERE b_writer LIKE ? ORDER BY b_num DESC",
		"UPDATE board SET b_hit = IFNULL(b_hit, 0)+1 WHERE b_num = ?",
		"SELECT * FROM board WHERE b_num LIKE ? OR b_title LIKE ? OR b_writer LIKE ? ORDER BY b_num DESC",
		"SELECT count(b_num) FROM board",
		"SELECT * FROM board ORDER BY b_num DESC LIMIT ?, ?"
	}; 
	   
	
	

	
	int INSERT = 0;
	int SELECT = 1;
	int UPDATE = 2;
	int DELETE = 3; 
	int SELECT_ONE = 4;
	int SEARCH_NUM = 5;
	int SEARCH_TITLE = 6;
	int SEARCH_WRITER = 7;
	int PLUS_HIT = 8;
	int SEARCH_ALL = 9;
	int TOTAL_COUNT = 10;
	int PAGING_LIST = 11;
}
