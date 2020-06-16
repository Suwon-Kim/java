import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIO {
	public static void writeToFile() {
		//FileWriter는 char형을 쓴다.
		FileWriter fw = null;
		try {
			fw = new FileWriter("c:\\dev\\data.txt");
			fw.write("하이 ~");
		} catch (IOException e) {
			
		} finally {
			MyUtils.closeAll(fw);
		}
	}
	public static void readFromFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("c:\\dev\\data.txt");
			int data = -1;
			while( (data = fr.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}
	public static void main(String[] args) {
		//writeToFile();
		readFromFile();
	}
}
