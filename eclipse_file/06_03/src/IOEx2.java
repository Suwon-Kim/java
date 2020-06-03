// Serializable -- > 직렬화 지원여부 
// 쓰기 대상이 되는 객체와 관련있는 모든 정보 (멤버 변수에 대해 검사)
// 검사 - > 비싼작업
// file : 1개 (객체) 
// 쓰기대상  -- > State 쓰기  // 무조건 써야됨 reset(); 별표 100개 (필터는 반드시 flush())를 해준다
//		  -- > Behavior -- > class 파일
// 클래스 파일의 관리 SerialVersion(ID)
// --> InvalidClassException
// Transient : 직렬화 대상에서 제외
// 마샬링, 언마샬링, 객체 직렬화 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOEx2 {
	public static void save() {
		try (			
			ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("data2.dat")
			);
		){
			oos.writeObject(new Foo(100, "some"));
			oos.flush();
			oos.reset();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * InvalidClassException
	 * write 하는 시점의 클래스 파일과 일치하지 않는 경우
	 */
	public static void load() {
		try (
			ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("data2.dat")
			);			
		){
			System.out.println(ois.readObject());	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		// save();
		load();
	}
}
