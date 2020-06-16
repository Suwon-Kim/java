import java.io.Closeable;

public class MyUtils {
	public static void closeAll(Closeable...c) {
		//매개 변수를 몇개 사용할지 정확히 알지 못할 때 이용하는게 가변길이 인수
		//Closeable[] c = {fis, fos}
		for(Closeable temp : c) {
			try {
				temp.close();
			} catch (Exception e) {
				
			}
		}
	}
}
