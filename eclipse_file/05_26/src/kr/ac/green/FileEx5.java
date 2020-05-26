package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx5 {
	public static void main(String[] args) {
		
		File f = new File("c:\\study\\a.txt");
		
		try {
			f.createNewFile();
			
			System.out.println(f.getParent()); 	// 경로를 얘기하는거 
			System.out.println(f.getName());	// 실제로 파일의 이름
			System.out.println(f.getPath());	// 경로 + 파일 합친거
			System.out.println(f.length());		//  크기,파일 사이즈 : byte
			System.out.println(f.lastModified());	// 마지막 수정시간 : long 타입임 알아 보기 힘들기 때문에 변경한다. 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




