import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

/*
 * ObjectInputStream, ObjectOutputStream
 * --> ���� (�а� ���� ����� ������ �� ����)
 * 
 */
public class IOEx1 {
	public static void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			//���� ���³� 
			fos = new FileOutputStream("data.dat");
			oos = new ObjectOutputStream(fos); 
			//fos�� marshalling �ϱ� ���� ObjectOutputStream ��ü�� ����
			//�������� �����͸� ����Ʈ�� ����� ����� ��Ʈ���� ���� �� �ִ� ���·� �ٲٴ�
			//��ȯ �۾��� ���Ѵ�.
			//�� ���ϴ� �Ѱ��� ��ü�� ����
			//���ʹ� ����ȭ�� �����Ѵ�
			Vector<MyObj> vec = new Vector<MyObj>();
			vec.add(new MyObj());
			vec.add(new MyObj());
			vec.add(new MyObj());
			vec.add(new MyObj());
			oos.writeObject(vec); // ��������� ����ȭ �˻�
			
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
			//���� �д³�
			fis = new FileInputStream("data.dat");
			ois = new ObjectInputStream(fis);
			
			Object o = ois.readObject();  //��ü���� Object�� �д´�
			Vector<?> vec = (Vector<?>)o;
			System.out.println(o);
		} catch (FileNotFoundException e) {
			
		} catch (ClassNotFoundException e) {
			//��ü�� ���¿� ����(��������� �޼ҵ�)�� �̷���� 
			//readObject(����)�ϱ� ���ؼ��� file�� ��ü�� �� Ŭ������ �־��
			//���� �� �� �ִ�.
			//final�� ������ ��ü���� �ٸ����� ������ final�� ����.
			//static final�� ������ ��ü���� �� �������� ������ �����
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(ois, fis);
		}
	}
	public static void main(String[] args) {
		save();
		load();
	}
}