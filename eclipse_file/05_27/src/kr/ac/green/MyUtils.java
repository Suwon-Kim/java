package kr.ac.green;
//AdvanceCopy와 관련됨
import java.io.Closeable;

public class MyUtils {
	//매개 변수를 몇 개 사용할지 정확히 알지 못할 때 이용하는게 가변길이 인수
	//Closeable(타입), C(변수)
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
