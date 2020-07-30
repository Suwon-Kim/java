package kr.ac.green;

public class Article {
	private String title;
	private String writer;
	private String contents;
	private String pw;
	
	public Article(String title, String writer, String contents, String pw) {
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.pw = pw;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
