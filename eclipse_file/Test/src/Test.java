import java.io.Serializable;

/*
 * Serializable 
 * 객체를 직렬화하기 위해서는 Serializable 인터페이스를 이용한다
 * 객체단위로 데이터를 저장합니다.
 * 직렬화를 빼고 싶다면 Trasnsient 사용하면 직렬화에서 빠지게 됩니다.
 * ObjectOutputStream은 Serializable 인터페이스를 implements 해주어준 것만 사용가능
 * 똑같은 클래스 파일을 가지고 있어야 Serializable된 데이터를 읽을 수 있다.
 * Serialize(직렬화) : 객체단위로 스트림을 통해서 전송하는 것
 * 객체 단위로 파일에 저장 할 수 있고, 네트워크를 통해서 전송할 수 있도록 해줍니다.
 * 자바에서는 Serializable 인터페이스가 이 역할을 수행한다.
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
