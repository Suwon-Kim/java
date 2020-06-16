import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Serializable --> ����ȭ ���� ����
 * ���� ����� �Ǵ� ��ü�� �����ִ� ��� ���� (��� ������ ���� �˻�)
 * �˻� - > ��� �۾�
 * file : 1�� (��ü)
 * ���� ��� -- > State ���� // ������ ��ߵ� reset(); ���� 100�� 
 * (���ʹ� �ݵ�� flush())�� ���ش�) 
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