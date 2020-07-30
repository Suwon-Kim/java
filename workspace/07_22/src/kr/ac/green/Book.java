package kr.ac.green;

import java.io.Serializable;

public class Book implements Serializable {
	private String title;
	private int price;
	private String author;
	private String date;
	
	public Book(String title, int price, String author, String date) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
} 
	


