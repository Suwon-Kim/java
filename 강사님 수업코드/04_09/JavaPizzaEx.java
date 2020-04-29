// 본사
abstract class JavaPizza {
	private void sayHello() {
		System.out.println("안녕하세요~자바피자입니다~");
	}
	public final void processing() {
		sayHello();
		cooking();
		boxing();
	}
	private void cooking() {
		System.out.println("맛의 비밀...");
	}
	protected abstract void boxing(); 
}
class JavaPizzaBusan extends JavaPizza {
	@Override
	protected void boxing() {
		System.out.println("우리가 남이가~");
	}
}
class JavaPizzaSeoul extends JavaPizza {
	@Override
	protected void boxing() {
		System.out.println("눈뜨세요. 코베어가요~");
	}
}
class JavaPizzaEx {
	public static void main(String[] args) {
		new JavaPizzaBusan().processing();
		new JavaPizzaSeoul().processing();
	}
}
