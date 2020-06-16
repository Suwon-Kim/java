import java.io.Serializable;

public class MyObj implements Serializable {
	private String name;
	private int number;
	private String str;
	
	private Some s = new Some();
	
	//직렬화를 지원하기 위해서는 그 안의 모든 객체가 직렬화를 지원해야한다.
	
	public MyObj() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Some getS() {
		return s;
	}
	public void setS(Some s) {
		this.s = s;
	}
}
