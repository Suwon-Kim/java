package kr.ac.green;
//AdvanceCopy�� ���õ�
import java.io.Closeable;

public class MyUtils {
	//�Ű� ������ �� �� ������� ��Ȯ�� ���� ���� �� �̿��ϴ°� �������� �μ�
	//Closeable(Ÿ��), C(����)
	//arr[c] = {fis, fos};
	//Closeable[] c = {fis, fos}
	public static void closeAll(Closeable... c) {
		for(Closeable temp : c) {
			try {
				temp.close();
			} catch(Exception e) {}
		}
	}
}
