import java.io.*;

class ExceptionEx8 {
	public static void main(String[] args)	{
		try {
			FileReader fr = new FileReader("a.txt");
		} catch(FileNotFoundException e) {
		}
	}
}
