package kr.ac.green;

import java.text.SimpleDateFormat;
import java.util.Date;
//��ȣ, ����, ����, �۾���, �ۼ���, ��й�ȣ
public class Article {
	
	private static int count = 0;
	private int num;	//��ȣ
	private String title; //�� ����
	private String contents; //�� ����
	private String writer; //�۾���
	private Date date;	//�ۼ��� 
	private String pw; //��й�ȣ
	private static SimpleDateFormat sdf = new SimpleDateFormat(
		"yyyy.MM.dd"
	);
	public Article(String title, String contents, String writer, String pw) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.pw = pw;
		this.num = ++count;
		this.date = new Date();
	}
	public Article(int num) {
		this.num = num;
	}
	public String getDateString() {
		return sdf.format(date);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Article)) {
			return false;
		}
		Article other = (Article)o;
		return num == other.getNum();
	}
}