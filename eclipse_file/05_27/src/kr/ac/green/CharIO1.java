package kr.ac.green;

import java.io.FileWriter;
import java.io.IOException;

public class CharIO1 {
	// char - writer (char Ÿ�� ����)
	public static void writeToFile() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("data.txt");
			fw.write("����~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fw);
		}
		
	}
}
