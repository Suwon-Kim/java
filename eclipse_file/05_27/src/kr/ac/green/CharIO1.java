package kr.ac.green;

import java.io.FileWriter;
import java.io.IOException;

public class CharIO1 {
	// char - writer (char 타입 쓰기)
	public static void writeToFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("data.txt");
			fw.write("하이~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fw);
		}
		
	}
}
