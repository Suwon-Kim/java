/*
	1. ¿¡·¯	
	2. 3 
	3. 5
*/
class Calc1 {
	// int n = 3;
	public void plus(int n) {
		n += 2;
	}
}
class UseCalc1 {
	public static void main(String[] args) {
		/*
		Calc1 c = new Calc1();
		int num = 3;
		c.plus(num);
		System.out.println(num);
		*/
		int n = 3;
		int m = n;
		m += 2;
		System.out.println(n);
	}
}
