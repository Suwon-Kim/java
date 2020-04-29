interface IFoo {
}
interface IBar {
}
class Some implements IFoo, IBar{
}
class UseSome {
	public static void main(String[] args) {
		Some s = new Some();
		IFoo f = s;
		IBar b = s;
		Object o = s;
	}
}
