package kr.ac.green;

import java.io.File;

public class FileEx3 {
	
	public static void main(String[] args) {
		File f = new File("c:\\a\\b\\c\\d");
		//f는 지금파일이 아님 d 하나만 가리키고 있다.
		//디렉토리도 파일이다.
		//파일은 뒤에 확장자가 있지만 없으므로 디렉토리임 (폴더이름)
		//씨 밑에 에이 에이 밑에 비 비 밑에 씨 씨 밑에 디
		//f가 나타내는건 d를 나타낸다. a,b,c는 경로
		// a만들고 b 만들고 c 만들고 d를 만들어야 만들어짐 
		
		// 상위경로까지 한번에 생성해준다 mkdirs() 
		// mkdir은 하나만 생성해줌  a가 안생김 아직까지는
		f.mkdirs(); // (한번에 만들 수 있는 메소드)

		File dir = new File("c:\\a");
		dir.delete(); // 왜 안지워질까 (a가 그대로 있음)
		// 걔 안에 파일이나 디렉토리가 없을때만 지워진다. 
		// (내부에 아무것도 없을 때 해당하는 경로를 삭제할 수있다)
		// a 안에는 지금 b,c ,d 가 있기 떄문에 지워지지 않음
	}
}
