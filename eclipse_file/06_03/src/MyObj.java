import java.io.Serializable;

public class MyObj implements Serializable {
	private String name;
	private int number;
	private String str;
	
	private Some s = new Some();
	
	//����ȭ�� �����ϱ� ���ؼ��� �� ���� ��� ��ü�� ����ȭ�� �����ؾ��Ѵ�.
	
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
