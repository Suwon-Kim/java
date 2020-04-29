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

	// model, price ������ ���� ����.
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
		Car c1 = new Car("����", 2500, "�ƹݶ�");
		Car c2 = new Car("�Ｚ", 2500, "�ƹݶ�");
		Car c3 = new Car("����", 2800, "�ƹݶ�");

		System.out.println(c1.equals(c3));
		System.out.println(c1.hashCode() == c3.hashCode());
	}
}
