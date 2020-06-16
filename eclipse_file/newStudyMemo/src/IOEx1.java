import java.io.IOException;
import java.io.InputStream;

public class IOEx1 {
	public static void main(String[] args) {
		InputStream is = System.in;
		
		try {
			int data = -1;
			while( (data = is.read()) != -1) {
				System.out.println("읽은 내용 : " + (char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of main");
	}
}
