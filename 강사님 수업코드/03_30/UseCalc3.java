class YourObj {
	public int n = 3;
}
class Calc3 {
	public void plus(int num) {
		num += 2;
	}
}
class UseCalc3 {
	public static void main(String[] args) {
		/*
		YourObj o = new YourObj();
		Calc3 c = new Calc3();
		c.plus(o.n);
		System.out.println(o.n);
		*/
		YourObj o = new YourObj();
		int num = o.n;
		num += 2;
		System.out.println(o.n);
	}
}
