interface IA {
	void todo();
}
interface IB {
	void todo();
}
class MySome {
}
// 복수구현(implements) 가능
class Foo extends MySome implements IA, IB{
	@Override
	public void todo() {
	}
}
class InterfaceEx2 {
	public static void main(String[] args) {

	}
}
