/*
	Wrapper Class

	byte				Byte
	short				Short
	int					Integer
	long				Long
	flaot				Float
	double				Double
	char				Character
	boolean				Boolean
*/
class WrapperClassEx {
	public static void main(String[] args)	{
		String str = new String("abc");
		String str2 = "abc";


		int num = 3;
		// int -> Integer
		Integer i = new Integer(num);
		
		// Integer -> int
		int other = i.intValue();
		System.out.println(other);

		// JDK1.5~
		// int -> Integer :: auto-boxing
		Integer i2 = 3;

		// Integer -> int :: auto-unboxing
		int num2 = i2;
	}
}
