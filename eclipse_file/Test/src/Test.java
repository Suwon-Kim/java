import java.io.Serializable;

/*
 * Serializable 
 * ��ü�� ����ȭ�ϱ� ���ؼ��� Serializable �������̽��� �̿��Ѵ�
 * ��ü������ �����͸� �����մϴ�.
 * ����ȭ�� ���� �ʹٸ� Trasnsient ����ϸ� ����ȭ���� ������ �˴ϴ�.
 * ObjectOutputStream�� Serializable �������̽��� implements ���־��� �͸� ��밡��
 * �Ȱ��� Ŭ���� ������ ������ �־�� Serializable�� �����͸� ���� �� �ִ�.
 * Serialize(����ȭ) : ��ü������ ��Ʈ���� ���ؼ� �����ϴ� ��
 * ��ü ������ ���Ͽ� ���� �� �� �ְ�, ��Ʈ��ũ�� ���ؼ� ������ �� �ֵ��� ���ݴϴ�.
 * �ڹٿ����� Serializable �������̽��� �� ������ �����Ѵ�.
 * 
 */
public class Test implements Serializable {
	private String bookName;
	private String num;
	private String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Test [bookName=" + bookName + ",num = " + num + "]";
	}
}
