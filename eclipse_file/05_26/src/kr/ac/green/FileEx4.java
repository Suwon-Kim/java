package kr.ac.green;

import java.io.File;

public class FileEx4 {
	
	//물리적 파일일때만 옳바른 결과를 돌려준다.
	public static void whatIsThis(File f) {
		if(!f.isFile()) { // 파일이 아니면 즉 디렉토리면
			System.out.println("파일이 아닙니다");
		}
		if(!f.isDirectory()) {
			System.out.println("디렉토리가 아닙니다.");
		}
	}// f가 파일인지 경로인지를 알아야 될때가 있다.
	public static void main(String[] args) {
		File dir = new File("c:\\study");
		// study가 확장자가 없는 파일일 수도 있고, 폴더일 수도 있어서 이것만 가지고 파일인지 디렉토리인지 알 수 없다.
		// 룰 : isFile, isDirectory << 물리적으로 존재할 때만 가능 물리적으로 존재하지 않을때는 false를 돌려줌 
		dir.mkdir(); 
		whatIsThis(dir); // 파일도 아니고 디렉토리도 아니다.
	}
}
