package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx2 {
	
		// 실행하면 만들어지고 다시 삭제되고 만들어지고 삭제되고
	public static void main(String[] args) {
		// 파일을 생성하기 위해서는 해당 경로가 물리적으로 존재해야 한다.
		// 내 컴퓨터에는 f 파일이 없다. (논리적인 파일) 코드상에만 있다.
		// exists : 디스크 상의 존재 여부 확인 
		// true : 물리적인 파일
		// false : 논리적인 파일
		
		File dir = new File("c:\\study"); // << 얘는 지금 디렉토리임
		
		if(!dir.exists()) {
			//경로생성  (디스크 상의 공간을 잡아먹지 않는다)
			dir.mkdir();
		}
		File f = new File(dir, "a.txt");
		
		if(f.exists()) {
			//삭제
			f.delete(); 
			//경로 삭제
			dir.delete();
		} else {
			try {
				// 물리적 파일 생성 (디스크 상의 공간을 잡아먹는다)
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		};
		
	}
}
