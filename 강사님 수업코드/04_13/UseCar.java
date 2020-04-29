class Car {
	private int price;
	private String maker;
	private String color;

	public Car(int price, String maker, String color) {
		setPrice(price);
		setMaker(maker);
		setColor(color);
	}
	public int getPrice() {
		return price;
	}
	public String getMaker() {
		return maker;
	}
	public String getColor() {
		return color;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setColor(String color) {
		this.color = color;
	}
	/*
		가격, 제조사, 색상이 전부 같은 경우 같다...
	*/
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Car)) {
			return false;
		}
		Car car = (Car)o;
		return price == car.getPrice() && maker.equals(car.getMaker()) 
			&& color.equals(car.getColor());
	}
}
class UseCar {
	public static void main(String[] args) {
		Car c1 = new Car(1000, "Kia", "white");
		Car c2 = new Car(1000, "Kia", "white");
		Car c3 = new Car(2000, "Kia", "white");
		Car c4 = new Car(1000, "samsung", "white");
		Car c5 = new Car(1000, "Kia", "black");

		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c4));
		System.out.println(c1.equals(c5));
	}
}
