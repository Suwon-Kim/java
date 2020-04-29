class Car {
	public String maker;
	public int price;
	public String model;
	
	public Car(String maker, int price, String model) {
		this.maker = maker;
		this.price = price;
		this.model = model;
	}

	@Override
	public int hashCode() {
		return model.hashCode() % 3;
	}

	// model, price 같으면 같은 차다.
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Car)) {
			return false;
		}
		Car c = (Car)o;

		return model.equals(c.model) && price == c.price;
	}
}
class UseCar {
	public static void main(String[] args)	{
		Car c1 = new Car("현대", 2500, "아반떼");
		Car c2 = new Car("삼성", 2500, "아반떼");
		Car c3 = new Car("현대", 2800, "아반떼");

		System.out.println(c1.equals(c3));
		System.out.println(c1.hashCode() == c3.hashCode());
	}
}
