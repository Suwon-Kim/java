import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOEx2 {
	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String line = null;
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			int data = -1;
			while ( (data = isr.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
