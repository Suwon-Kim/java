class Car {
	public void start() {
		System.out.println("A");
		System.out.println("B");
		System.out.println("C");
		System.out.println("D");
		System.out.println("E");
	}
	
}
class CarTest {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println("before");
		c.start();
		System.out.println("after");
	}
}
