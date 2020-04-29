class MyObj {
	public int num = 3;
}
class Calc2 {
	public void plus(MyObj obj) {
		obj.num += 2;
	}
}
class UseCalc2 {
	public static void main(String[] args) {
		/*
		MyObj o = new MyObj();
		Calc2 c = new Calc2();
		c.plus(o);
		System.out.println(o.num);
		*/
		MyObj o = new MyObj();
		MyObj o2 = o;
		o2.num += 2;
		System.out.println(o.num);
	}
}
