package kr.ac.green;

public class Doc implements Comparable<Doc>{
	private static int count = 1;
	private int num;
	private String writer;
	private String contents;
	private String date;
	
	public Doc(String writer, String contents, String date) {
		super();
		this.writer = writer;
		this.contents = contents;
		this.date = date;
		num = count++;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Doc.count = count;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public int compareTo(Doc other) {
		return (num - other.getNum()) * -1;
	}
}
