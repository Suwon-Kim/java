class Car {
	private int speed;
	private int mileage;
	private String color;
	// 자동차의 시리얼 번호
	private int id;
	// 실체화된 Car 객체의 개수를 위한 정적 변수
	private static int numberOfCars = 0;
	public Car(int s, int m, String c) {
		speed = s;
		mileage = m;
		color = c;
		// 자동차의 개수를 증가하고 id 번호를 할당한다.
		id = ++numberOfCars;
	}
	// 정적 메소드 
	public static int getNumberOfCars() {
		return numberOfCars; // OK!
	}
}
public class CarTest3 {
	public static void main(String args[]) {
		Car c1 = new Car(100, 0, "blue"); 	// 첫 번째 생성자 호출
		Car c2 = new Car(0, 0, "white"); 	// 첫 번째 생성자 호출
		int n = Car.getNumberOfCars();	// 정적 메소드 호출
		System.out.println("지금까지 생성된 자동차 수 = " + n);
	}
}
