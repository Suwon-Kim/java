package kr.ac.green;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static kr.ac.green.MyUtils.*;
//편하긴 한대 한개만 써서 가능하지 여러개에서 불러올 때 그냥 메소드 이름만 나오기 때문에 어디서 나왔는지 알 수가 없다. 있는데 쓰지않음 
//-- > 마이유틸스안의 것들을 내꺼 처럼 쓸 수 있다. finally에 MyUtils를 생략 할 수 있다.
public class AdvancedCopy {

	public static void newCopy() {
		File src = new File("c:\\dev\\eclipse.zip");
		File copy = new File("c:\\dev\\copy.zip");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		long time = System.currentTimeMillis();
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(copy);
			
			int count = -1;
			//5천 바이트씩 읽는다.
			byte[] buffer = new byte[5000];
			 
			while( (count = fis.read(buffer)) != -1 ) {
				fos.write(buffer, 0, count);
				//읽어서 버퍼에 채우라는 말 
				//count = 읽은 바이트 수 
				//5천 바이트 씩 카운트에 담고
			}
			time = System.currentTimeMillis() - time;
			System.out.println(time + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fis, fos);
		}
	}	
	public static void main(String[] args) {		
		newCopy();
	}
}






