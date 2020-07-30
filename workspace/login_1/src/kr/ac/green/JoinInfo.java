package kr.ac.green;

public class JoinInfo {
	private String id;
	private String pw;
	private String re;
	private String name;
	private String nick;
	
	public JoinInfo(String id){
		this.id = id;
	} 
	
	public JoinInfo(String id, String pw, String re, String name, String nick) {
		this.id = id;
		this.pw = pw;
		this.re = re;
		this.name = name;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	public boolean equals(Object o) {
		if(o == null || !(o instanceof JoinInfo)) {
			return false;
		}
		JoinInfo other = (JoinInfo) o;
		return other.id.equals(id);
	}
}
