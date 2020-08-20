package com.jang.member;

import java.sql.Connection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {

	@Autowired
	private IMemberDAO dao; 
	
	public int insertBoard(Member member) {
		Connection con = dao.connect();
		int result = dao.insertBoard(con, member);
		dao.disconnect(con);
		return result;
	}
	
	public Member loginCheck(Member member) {
		Connection con = dao.connect();
		Member result = dao.loginCheck(con, member);
		dao.disconnect(con);
		return result;
	}
	  
	public int getCheckId(String mem_id) {
		Connection con = dao.connect();
		int result = dao.getCheckId(con, mem_id);
		dao.disconnect(con);
		return result;
	}
	
	public Member memberLogin(HashMap<String, String> map) {
		Connection con = dao.connect();
		Member result = dao.memberLogin(con, map);
		dao.disconnect(con);
		return result; 
	}
	
}
