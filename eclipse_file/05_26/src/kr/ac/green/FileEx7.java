package kr.ac.green;

import java.io.File;
import java.io.IOException;

public class FileEx7 {
	public static void main(String[] args) {

		File f = new File("..\\..\\a.txt"); // 현재 위치에 있는 a.txt이다. (상대경로임)
		// Package 정보는 제외한다.
		// 만든사람이 절대경로를 지정했는지 상대경로를 지정했는지 모른다. 
		// getParent()가 null인 이유
		// null이 나왔다고 해서 경로가 없는건 아니다 실제로 경로는 있다.
		// 상대경로 표기법으로 만들면 앞에 경로가 있는지 없는지 모른다.
		// 현재위치를 모른다.
		System.out.println(f.getParent());	// 경로가 보장이 되지 않아서 null이다.
		System.out.println(f.getName());
		System.out.println(f.getPath());
		System.out.println("==============================================");
		
//		System.out.println(f.getAbsolutePath()); // 문자열밖에 알 수 없다 (String)
		File other = f.getAbsoluteFile();	// 파일 형태로 돌려받는다 (파일에 조작이 필요하면)
		System.out.println(other.getParent());
		System.out.println(other.getName());
		System.out.println(other.getPath());
		System.out.println("==============================================");
		try{
			//이산 경로 (경로를 계산해줌)
			//사용자한테 경로를 노출해야 할 때 
//			System.out.println(f.getCanonicalPath());
			File another = f.getCanonicalFile();
			System.out.println(another.getParent());
			System.out.println(another.getName());
			System.out.println(another.getPath());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

/*
 * 	c:\other , c:\some
 * 	경로 : 상대경로, 절대경로 표기법
 *  상대 경로 : 현재위치부터 출발한다 
 *  ex) .(현재위치), ..(한단계 위) ..\some\a.txt  
 *  ex) 현재 other인데 some으로 들어갈려면 c로 갔다가 some으로 간다.
 *  절대 경로 : 출발점이  root(여기서는 c) 부터 시작해서 읽어오는것 
 *  ex) "C:\some\a.txt" 어디에 있던지간에 경로가 변하지 않는다.
 */

/*
 * I/O Stream		Input (read) <-ㅁ Output(write)-> 
 * 					 
 * 1. 방향(단)
 * 2. 순차적
 * 
 *  byte - I : InputStream
 *  	 - O : OutputStream
--------------------------------
 *  char - I : Reader
 * 		 - O : Writer
 * +
 * 
 *  FileInputStream << 봐야하는건 이름이 InputStream으로 끝남 (바이트 단위로 읽기함)
 *  		   File(대상임) << 1. 대상 2. 특징 
 */




