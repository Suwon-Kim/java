package kr.ac.green;

import java.io.File;

/*
 * java.io.File
 * 		========================================================
 * 		- 형태
 * 		1. 파일
 * 		2. 디렉토리 (폴더, 경로) : c : \ dev \ eclipse (그냥 구분자이다)
 *  	========================================================
 *  	- 디스크 상의 존재유무
 *  	1. 논리적 파일 (파일,디렉토리) : 코드 상에만 존재하는 파일 (실제 디스크 상에는 없다)
 *  	2. 물리적 파일 (파일,디렉토리) : 실제 디스크장에 저장 되어 있는 파일
 *  
 *  	파일이 존재하는 이유는 영속적인 데이터, 
 *  	java.io -- > 입력,출력 
 *  	프로그램의 성능을 좌지우지 하는 어떤 제일 중요한 요소가 입출력
 *  	
 */

public class FileEx1 {
	
	public static void main(String[] args) {
		// target (c:\study\a.txt)
		// \n,\t  우리가 쓰는건 그냥 역슬레쉬이기 때문에 \\ 2개를 해줘야 한다. \ <<< 의미가 있기 때문에
		// f1, f2, f3는 같은 파일을 나타낸다.
		File f1 = new File("c:\\study\\a.txt");
		File f2 = new File("c:\\study\\","a.txt");
		// File은 경로를 나타낼 수 있다.
		File dir = new File("c:\\study");
		File f3 = new File(dir, "a.txt");
		
		//3가지 방법 다 알아놓자 많이 쓰인다.
	}
}















