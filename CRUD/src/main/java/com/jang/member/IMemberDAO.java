package com.jang.member;

import java.sql.Connection;
import java.util.HashMap;


public interface IMemberDAO {
	Connection connect();
	void disconnect(Connection con); 
	
	int insertBoard(Connection con, Member member);
	
	Member loginCheck(Connection con, Member member);
	
	// 아이디 중복확인
	int getCheckId(Connection con, String mem_id);
	
	// 로그인 체크
	Member memberLogin(Connection con, HashMap<String, String> map); 
}
