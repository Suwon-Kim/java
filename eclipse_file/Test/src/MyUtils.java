import java.io.Closeable;

public class MyUtils {
	public static void closeAll(Closeable...c) {
		//�Ű� ������ � ������� ��Ȯ�� ���� ���� �� �̿��ϴ°� �������� �μ�
		//Closeable[] c = {fis, fos}
		for(Closeable temp : c) {
			try {
				temp.close();
			} catch (Exception e) {
				
			}
		}
	}
}
