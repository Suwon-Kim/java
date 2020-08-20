package com.jang.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private int b_num;
	private String b_title;
	private String b_writer;
	private String b_contents;
	private String b_reg;
	private byte[] filename1;
	private int b_hit;
	private String b_id;

	public Board() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		b_reg = sdf.format(new Date());
	}

	public Board(int b_num, String b_title, String b_writer, String b_contents, String b_reg, byte[] filename1,
			int b_hit, String b_id) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_contents = b_contents;
		this.b_reg = b_reg;
		this.filename1 = filename1;
		this.b_hit = b_hit;
		this.b_id = b_id;
	}

	// 상세보기
	public Board(int b_num, String b_title, String b_writer, String b_contents, byte[] filename1, String b_reg,
			int b_hit) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_contents = b_contents;
		this.filename1 = filename1; 
		this.b_reg = b_reg;
		this.b_hit = b_hit;
	}

	public Board(int b_num, String b_title, String b_writer, String b_contents, String b_reg, int b_hit) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_contents = b_contents;
		this.b_reg = b_reg;
		this.b_hit = b_hit;
	}

	public Board(int b_num, String b_title, String b_writer, String b_contents, String b_reg) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_contents = b_contents;
		this.b_reg = b_reg;
	}

	public Board(int b_num, String b_title, String b_contents) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_contents = b_contents;
	}


	public byte[] getFilename1() {
		return filename1;
	}

	public void setFilename1(byte[] filename1) {
		this.filename1 = filename1;
	}

	public int getB_hit() {
		return b_hit;
	}

	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_contents() {
		return b_contents;
	}

	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}

	public String getB_reg() {
		return b_reg;
	}

	public void setB_reg(String b_reg) {
		this.b_reg = b_reg;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}


}
