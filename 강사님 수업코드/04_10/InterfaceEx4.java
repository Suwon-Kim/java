interface IFirst {
	void first();
}
interface ISecond {
	void second();
}
interface IThird extends IFirst, ISecond {
	void third();
}
class Numbers implements IFirst, ISecond, IThird {
	@Override
	public void first() {
	}
	@Override
	public void second() {
	}
	@Override
	public void third() {
	}
}
class InterfaceEx4 {
	public static void main(String[] args) {

	}
}
