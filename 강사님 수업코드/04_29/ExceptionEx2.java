/*
public class FileReader {
	public FileReader(String path) throws FileNotFoundException {
		...
		FileNotFoundException 발생가능성이 있음
	}
}

*/

import java.io.*;
class MyLib {
	public static int num = 0;
	public static void todo() throws FileNotFoundException {
		try {
			// 예외발생
			new FileReader("a.txt");		
		} finally {
			// Some
		}
	}
}
class Foo {
	public void call() {
		try {
			MyLib.todo();
		} catch(Exception e) {
			// Some + A
		}
	}
}
class Bar {
	public void process() {
		try {
			MyLib.todo();
		} catch(Exception e) {
			// Some + B
		}
	}
}
class ExceptionEx2 {
	public static void main(String[] args)	{

	}
}
