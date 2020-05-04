문자열 (CharSequence)

- Character
- 줄 - > 순서 + 복수
- 대표적인 클래스 - > String, StringBuffer, StringBuilder

String 

- 불변(객체생성 후 나타내는 값을 변경할 수 없다)

  - <-> VS StringBuffer, StringBuilder (thread safe)

- 공유될 수 있다.

  

  

```java
class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		String str4 = new String("abc");

		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str1.equals(str4));

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);
	}
}

```

```java
class StringEx2 {
	public static void main(String[] args) {
		String str = "abcdef";
		
		// 글자수
		System.out.println(str.length());
		
		// 해당 인덱스의 글자 (char) 구하기
		char c = str.charAt(3);
		System.out.println(c);

		for(int idx = 0; idx < str.length(); idx++) {
			//System.out.println(str.charAt(idx));

			//형변환이 가능하다.
			System.out.println((int)(str.charAt(idx)));
		}

		System.out.println("abc".compareTo("x"));
		System.out.println('a' - 'x');
		System.out.println((int)'힣');
		System.out.println((int)'x');

		System.out.println("abc".compareTo("ABC"));
		//abc > ABC (양수이므로)
		System.out.println("abc".compareToIgnoreCase("ABC"));
		// 대소문자 관계없이 컴페어 하라
		System.out.println("abc".equals("ABC"));

		System.out.println("abc".equalsIgnoreCase("ABC"));
		// 대소문자 관계없이 컴페어 하라
		
		String newStr = str.toUpperCase();
		//str은 변하지 않는다. -- > toUpeersCase()는 str을 대문자로 변경한것이 아니라
		//str을 새로 만든거다.
		//str의 내용이 대문자로 변경된 것이 아님.
		//대문자로 구성된 새로운 String객체를 만들어서 리턴
		System.out.println(newStr);
		System.out.println(newStr.toLowerCase());
		System.out.println(str);
		
		
	}
}
```

```java
class StringEx3 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "def";

		System.out.println(str1.concat(str2));
		//str1과 str2를 합친 새로운 객체가 되는거임 변환게 아님 str1, str2가 

		System.out.println("abcdef".contains("cd"));

		System.out.println(str1.startsWith("ab"));
		// str1이 ab로 시작하는가?
		System.out.println(str1.endsWith("bc"));
		// str1이 bc로 끝나는가 ? 
 
		/*
			언제 쓸 수 있을까?
			"c:\\src\\Some.java"
			"c:\\src\\Other.java"
		*/
		
		/*
			trim : 문자열 앞뒤의 공백을 제거
				단, 문자열 내부의 공백은 제거하지 않는다.
		*/
		String str3 = "ab              c                           ";
		System.out.println(str3.length());
		System.out.println(str3.trim().length());
		//문자열 사이의 공백은 처리해주지 않는다 
		//     abc, << 이러한 공백만 처리

		/*
			type - > String
		*/
		String s1 = String.valueOf('c');
		String s2 = String.valueOf(1);
		String s3 = String.valueOf(3.14);
		String s4 = String.valueOf(new char[] {'c','a','t'});
		System.out.println(s4);

	}
}


//concatenate 미국식 
//사슬같이 잇다, 연쇄시키다,연관시키다
//trim
//다듬다, 손질하다, 잘라내다
```

```java
class StringEx4 {
	public static void main(String[] args) {
		String str = "abcdefabghi";
					//01234567890
		
		//매우 중요하다.
		System.out.println(str.indexOf("ab",1));
		System.out.println(str.lastIndexOf("ab",5));
		System.out.println(str.indexOf("xx"));

		System.out.println(str.substring(2));
		//2부터 끝까지 잘라온다.
		System.out.println(str.substring(2,7));
		// 2 ~ 7 미만까지 잘라온다.
	}
}

```

```java
/*
	값이 변하는 문자열

*/

class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer("abc");
		
		// XYZ를 추가한다. buf의 내용이 변함
		buf.append("XYZ");

		System.out.println(buf);
		/*
			012345
			abcXYZ

		*/

		buf.delete(1,4);
		System.out.println(buf);

		buf.insert(1,"$$$");
		System.out.println(buf);

		buf.reverse();
		System.out.println(buf);
		
		// 해당하는 새로운 문자열을 리턴
		String str = buf.substring(1,3);
		System.out.println(str);
		System.out.println(buf);

		buf.append("a").append("b").append("c").insert(1,"xxx");
		System.out.println(buf);
	}
}

//Append
//덧붙이다, 첨부하다
```

```java
class Human {
	private String name;
	private int age;

	public Human setName(String name) {
		this.name = name;
		return this
	}
	public Human setAge(int age) {
		this.age = age;
		return this
	}
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h = new Human();
		h.setName("박보검").setAge(35);
		System.out.println(h);
	}
}

//예를 든거지 개터 세터는 void임
```

```java
class Human {
	private String name;
	private int age;

	public Human setName(String name) {
		this.name = name;
		return this
	}
	public Human setAge(int age) {
		this.age = age;
		return this
	}
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h = new Human();
		h.setName("박보검").setAge(35);
		System.out.println(h);
	}
}

//예를 든거지 개터 세터는 void임
```

```java
class StringVsStringBuffer {
	public static int count = 1000000;
	public static void caseOfString() {
		String str = "";
		// System.currentTimeMillis() -> 현재시간을 ms단위로 구한다.
		long time = System.currentTimeMillis();
		for(int i=0; i<count; i++) {
			str += "a";
			//계속 새로 만들어야하는 단점
		}
		time = System.currentTimeMillis() - time;
		System.out.println("String : " + time + "ms");
	}
	public static void caseOfStringBuffer() {
		StringBuffer buf = new StringBuffer();
		long time = System.currentTimeMillis();
		for(int i=0; i<count; i++) {
			buf.append("a");
			//새로운 객체가 계속 생성되지 않음
		}
		time = System.currentTimeMillis() - time;
		System.out.println("StringBuffer : " + time + "ms");
	}
	public static void main(String[] args)	{
		caseOfString();
		//caseOfStringBuffer();
	}
}

```

```java
/*
	String의 아래 메서드를 활용해서 주석처럼 출력하는 코드를 완성 하시오.
	indexOf, lastIndexOf
	substring
	3,8,11,14
	str.length = 20;
	String str = "태산이 높다하되 하늘 아래 뫼이로다.";
*/
class Homework {	
	public static void answer1(String str) {
			int result = 0;
			for(int j = 0; j < 5; j++) {
				int index = str.indexOf(" ", result);
				if(result != 0) {
					System.out.println(str.substring(0,index));
				}
				result = index + j;
			}
			System.out.println(str);
	}
	public static void answer2(String str) {
		int result = 20;
		for(int j = 1; j < 6; j++) {	
			int index = str.lastIndexOf(" ",result) + 1;
			//index = 15;

			if(result != 20) {
				System.out.println(str.substring(index,20));
			}
			result = index - j; 				
		}
		System.out.println(str);
	}
	public static void answer3(String str) {
		int result = 0;
		for(int i = 0; i < 4; i++) {
			int index = str.indexOf(" ",result);
			if(i == 0) {
				System.out.println(str.substring(0,index));
			} else {
				System.out.println(str.substring(result, index));
			}
			result = index + 1; 
		}
		System.out.println(str.substring(result,20));
	}
	public static void answer4(String str) {
		str = " " + str;
		int result = 21;
		int index =0;
		for(int i = 0; i < 5; i++){
			index = str.lastIndexOf(" ", result-1);
			//index = 15
			//index = 12
			//index = 9
			//index = 5
			System.out.println(str.substring(index,result));			
			result = index;

		}
		
	}
	public static void answer5(String str){
			String[] split = str.split(" ");
			for(String s: split){
				System.out.println(s);
			}
		}
		
		/*
			(15,20)
			(12,14)
			(9,11)
			(4,8)
			(0,4)
			뫼이로다.
			아래
			하늘
			높다하되
			태산이
		*/
	
	public static void main(String[] args) {
		String str = "태산이 높다하되 하늘 아래 뫼이로다.";
		
		System.out.println();
		answer4(str);
	}
}

```

