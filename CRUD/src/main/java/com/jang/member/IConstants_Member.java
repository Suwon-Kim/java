package com.jang.member;

public interface IConstants_Member {
	String DRIVER = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/test";
	  
	String UID = "root"; 
	String UPW = "1234";  
	
	String[] SQLS = {
			"INSERT INTO member (mem_id, mem_name, mem_pw, mem_email, mem_reg) VALUES (?,?,?,?,?)",
			"SELECT * FROM member WHERE mem_id = ? AND mem_pw = ?",
			"SELECT count(*) AS cnt FROM member WHERE mem_id = ?"
		}; 
		   
		int INSERT = 0;
		int LOGIN_CHECK = 1;
		int CHECK_ID = 2;
}
