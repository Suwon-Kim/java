import java.util.HashSet;
import java.util.StringTokenizer;

public class FileInfo {
	private String date;		//작성일
	private String title;		//파일제목
	private String tag;			//태그
	private String pw;			//패스워드
	private String content;		//내용
	
	private HashSet<String> tagSet = new HashSet<String>();	//tag 내용을 ','를 구분자로 나눠 tagSet에 담는다.
	
	private StringTokenizer st;
	
	public FileInfo(String date, String title, String tag, String content) {
		setDate(date);
		setTitle(title);
		setTag(tag);
		setContent(content);
	}
	public FileInfo(String date, String title, String tag, String pw, String content) {
		setDate(date);
		setTitle(title);
		setTag(tag);
		setPw(pw);
		setContent(content);
	}
	
	public HashSet<String> getTagSet() {
		return tagSet;
	}
	//모든 내용이 일치해야 같은 객체다
	public boolean equals(Object o) {
		if(o == null || !(o instanceof FileInfo)) {
			return false;
		}
		FileInfo tmp = (FileInfo)o;
		return date.equals(tmp.getDate()) && 
				title.equals(tmp.getTitle()) &&
				tag.equals(tmp.getTag()) &&
				pw.equals(tmp.getPw()) &&
				content.equals(tmp.getContent());
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
		
		tagSet.clear();
		st = new StringTokenizer(tag, ",");
		while(st.hasMoreTokens()) {
			tagSet.add(st.nextToken());
		}
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return date + ", " + title + ", " + tag + ", " + pw + ", " + content;
	}
	
	
}
