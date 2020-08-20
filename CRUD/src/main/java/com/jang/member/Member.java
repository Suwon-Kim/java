package com.jang.member;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String mem_id;
	private String mem_name;
	private String mem_pw;
	private String mem_email;
	private String mem_reg;

	public Member() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy.MM.dd");
		mem_reg = sdf.format(new Date());
	}

	public Member(String mem_id, String mem_pw) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
	}
	
	public Member(String mem_id, String mem_name, String mem_email) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	
	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_reg() {
		return mem_reg;
	}

	public void setMem_reg(String mem_reg) {
		this.mem_reg = mem_reg;
	}

}
