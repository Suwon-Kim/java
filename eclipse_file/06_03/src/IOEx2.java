import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Serializable --> 직렬화 지원 여부
 * 쓰기 대상이 되는 객체와 관련있는 모든 정보 (멤버 변수에 대해 검사)
 * 검사 - > 비싼 작업
 * file : 1개 (객체)
 * 쓰기 대상 -- > State 쓰기 // 무조건 써야됨 reset(); 별포 100개 
 * (필터는 반드시 flush())를 해준다) 
 */
public class IOEx2 {
	public static void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("data2.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Foo(100, "some"));
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(oos,fos);
		}
	}
	public static void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("data2.dat");
			ois = new ObjectInputStream(fis);
			
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
		save();
		load();
	}
}