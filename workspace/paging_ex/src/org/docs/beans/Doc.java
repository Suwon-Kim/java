package org.docs.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Doc {
	private int d_num;
	private String d_title;
	private String d_content;
	private String d_author;
	private String d_date;
	
	public Doc() {
		this.setDate();
	}
	
	public Doc(String d_title, String d_content, String d_author) {
		this.d_title = d_title;
		this.d_content = d_content;
		this.d_author = d_author;
		this.setDate();
	}
	
	public Doc(int d_num, String d_title, String d_content, String d_author, String d_date) {
		this.d_num = d_num;
		this.d_title = d_title;
		this.d_content = d_content;
		this.d_author = d_author;
		this.d_date = d_date;
	}
	
	private void setDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-kk:mm");
		this.d_date = sdf.format(new Date());
	}

	public int getD_num() {
		return d_num;
	}

	public void setD_num(int d_num) {
		this.d_num = d_num;
	}

	public String getD_title() {
		return d_title;
	}

	public void setD_title(String d_title) {
		this.d_title = d_title;
	}

	public String getD_content() {
		return d_content;
	}

	public void setD_content(String d_content) {
		this.d_content = d_content;
	}

	public String getD_author() {
		return d_author;
	}

	public void setD_author(String d_author) {
		this.d_author = d_author;
	}

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	
	
}
