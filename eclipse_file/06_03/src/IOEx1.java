
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

/*
 * ObjectInputStream, ObjectOutputStream 
 * 	-> 필터(읽고 쓰는 대상을 선정할 수 없다.)
 */
public class IOEx1 {
	// instance -> File
	public static void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("data.dat");
			oos = new ObjectOutputStream(fos);
			// 1 파일 당 1 개의 객체만 쓰자
			// 백터는 직렬화를 지원한다. 
			Vector<MyObj> vec = new Vector<MyObj>();
			vec.add(new MyObj());
			vec.add(new MyObj());
			vec.add(new MyObj());
			vec.add(new MyObj());
			oos.writeObject(vec); //저 일을 하기 위해서 하는 일이 굉장히 많음 멤버 변수에 멤버변수에 직렬화 검사 
	
			oos.flush();
			oos.reset();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(oos, fos);
		}
	}

	public static void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("data.dat");
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();
			Vector<?> vec = (Vector<?>)o;
			System.out.println(o);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			//객체는 상태와 행위 (멤버변수와 메서드)로 이루어짐
			// readObject(복원) 하기 위해서는 file과 객체를 찍어낸 클래스가 있어야 복원 할 수가 있다.
			// 카톡 사진 참고 
			// final만 쓸때는 객체마다 다른값을 가지면 final을 쓴다 .
			// static final을 쓸때는 객체마다 다 같은값을 가지면 static final을 쓴다.
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(ois, fis);
		}

	}

	public static void main(String[] args) {
		save();
		// load();
	}
}
