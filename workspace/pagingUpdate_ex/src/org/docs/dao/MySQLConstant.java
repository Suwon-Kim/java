package org.docs.dao;

public interface MySQLConstant {
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/test";
	String UID = "root";
	String UPW = "1234";
	
	int GETALL = 0;
	int WRITE = 1;
	int DELETE = 2;
	int UPDATE = 3;
	int FIND = 4;
	int COUNT = 5;
	int LIST = 6;
	
	String[] SQLS = {
		"SELECT * FROM docs ORDER BY d_num DESC",
		"INSERT INTO docs (d_title, d_author, d_content, d_date) VALUES(?,?,?,?)",
		"DELETE FROM docs WHERE d_num = ?",
		"UPDATE docs SET d_title = ?, d_content = ?, d_author = ?, d_date = ? WHERE d_num = ?",
		"SELECT * FROM docs WHERE d_num = ?",
		"SELECT count(d_num) FROM docs",
		"SELECT * FROM docs ORDER BY d_num DESC LIMIT ?, ?"
	};
}
//"SELECT * FROM docs ORDER BY d_num DESC LIMIT ?, ?" 하는 이유는 
//응답속도랑 부하속도가 나아지고 사용자가 보기도 편하고 (페이징)
