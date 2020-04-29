프로그램이 종료됬다 -- > CallStack이 다 비워졌다

------------------

```java
/*
	예외처리 
	1. try-catch : 예외상황을 직접 처리
	2. throws	// 예외처리를 전가한다. 호출하는 곳으로 전가함

*/
import java.io.*;
class ExceptionEx1 {
	public static void first() {
		try {
			second();
		} catch(FileNotFoundException e) {
		
		}
	}
	public static void second() throws FileNotFoundException {
		FileReader fr = new FileReader("a.txt");
	}
	public static void main(String[] args) {
		first();
	}
}
```

```java
import java.io.*;
class ExceptionEx1 {
	public static void first() throws FileNotFoundException  {
		second();
	}
	public static void second() throws FileNotFoundException {
		FileReader fr = new FileReader("a.txt");
	}
	// 이런 코드는 없다. 예외처리 된게 아님
	public static void main(String[] args) throws FileNotFoundException {
		first();
	}
}
```

---

```java
/*	
	public class FileReader {
		public FileReader(String path) throws FileNotFoundException {
						...............
			FileNotFoundException 발생 가능성이 있음
		}
	}

*/
import java.io.*;

class MyLib {
	public static void todo() throws FileNotFoundException {
		// 예외발생
		new FileReader("a.txt");
	}
}
class Foo {
	public void call() {
		try {
			MyLib.todo();
		} catch (Exception e) {
			// A
		}
	}
}
class Bar {
	public void call() {
		try {
			MyLib.todo();
		} catch (Exception e) {
			// B
		}
	}
}
class ExceptionEx2 {
	public static void main(String[] args) {
	
	}
}
```

```java
/*
	public class FileReader {
		public FileReader(String path) throws FileNotFoundException {
						...............
			FileNotFoundException 발생 가능성이 있음
		}
	}
*/
import java.io.*;

class MyLib {
	public static void todo() throws FileNotFoundException {
		try {
			// 예외발생
		} finally {
			// Some 
		}
		// 예외발생
		new FileReader("a.txt");
	}
}
class Foo {
	public void call() {
		try {
			MyLib.todo();
		} catch (Exception e) {
			// Some + A
		}
	}
}
class Bar {
	public void call() {
		try {
			MyLib.todo();
		} catch (Exception e) {
			// Some + B
		}
	}
}
class ExceptionEx2 {
	public static void main(String[] args) {
	
	}
}
```

```java
/*
	예외상황 정의
*/
class TooLongArraySizeException extends Exception {
		public TooLongArraySizeException() {
			super("3개를 초과할 수 없습니다.");
		}
		public TooLongArraySizeException(int validCount) {
			super(validCount + "개를 초과할 수 없습니다.");
		}
}
class ExceptionEx3 {
	public static void printSum(int...nums) throws TooLongArraySizeException {	//가변길이 인자
	int count = 5;
		// 나는 원소가 3개를 초과하는 걸 원치 않는다.
		// 배열의 길이가 3초과면 예외로 판정한다.
		/* 
		if(nums.length > 3 ) {
			// 예외가 발생하는 상황
			System.out.println("OUT");
		} else {
			//합을 구한다.	
		}
		*/
		if(nums.length > count) {
			// 예외가 발생하는 상황

			// 1. 예외객체 정의
			TooLongArraySizeException e = new TooLongArraySizeException(count);
			// 2. 발생
			throw e;
		} else {
			int sum = 0;
			for(int n : nums) {
				sum += n;
			}
			System.out.println(sum);
		}
		
	}

	public static void main(String[] args) {
		try {
			printSum(1,2,3);
		} catch (TooLongArraySizeException e) {
			System.out.println(e.getMessage());
		}

		try {
			printSum(1,2,3,4,5,6,7);
		} catch (TooLongArraySizeException e) {
			System.out.println(e.getMessage());
		}
	}
}

```

```java
class ExceptionEx4 {
	public static void main (String[] args) {
		try {
			int num = 0;
			while(true) {
				num++;

				if(num == 100) {
					throw new Exception();
				}
			}
	} catch (Exception e) { 
		System.out.println("end");
	}
}
```

```java
class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void love(Human h)throws CrimeUnderTheAgeOf19{
		//미성년자를 사랑할 수 없다 : 예외상황
		if(h.getAge()<=19){
			//예외발생
			throw new CrimeUnderTheAgeOf19();
		}else {
			System.out.println(name + "♥" + h.getName());
		}
		
	}
}
class CrimeUnderTheAgeOf19 extends Exception{
	public CrimeUnderTheAgeOf19(){
		super("철컹철컹");
	}
}

class ExceptionEx5{
	public static void main(String[] args) {
		Human h1 = new Human("박보검",26);
		Human h2 = new Human("제니",25);
		try{
		h1.love(h2);
		}catch(CrimeUnderTheAgeOf19 e){
			System.out.println(e.getMessage());
		}

		Human h3 = new Human("X영욱",44);
		Human h4 = new Human("가현",17);
		try{
			h3.love(h4);
		}catch(CrimeUnderTheAgeOf19 e){
			System.out.println(e.getMessage());
		}

		Human h5 = new Human("승미",18);
		try{
			h5.love(h4);
		} catch(CrimeUnderTheAgeOf19 e){
			System.out.println(e.getMessage());
		}
	}
}
```

