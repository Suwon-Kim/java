/*
		Engine
	============================
	- cc : int
	- weight : double
	- maker : String
	============================
	+ Engine(cc:int, weight:double, maker:String)
	+ getters/setters
	+ toString() : String


		Car
	============================
	- speed : int
	- maker : String
	- engine : Engine
	============================
	+ Car(speed:int, maker:String, engine:Engine)
	+ getters / setters
	+ toString() : String
*/
class Engine {
	private int cc;
	private double weight;
	private String maker;

	public Engine(int cc, double weight, String maker) {
		setCc(cc);
		setWeight(weight);
		setMaker(maker);
	}

	public int getCc() {
		return cc;
	}
	public double getWeight() {
		return weight;
	}
	public String getMaker() {
		return maker;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String toString() {
		return maker + " engine(" + cc + "cc, " + weight + "kg)";
	}
}
// Car has-a Engine
class Car {
	private int speed;
	private String maker;
	private Engine engine;

	public Car(int speed, String maker, Engine engine) {
		setSpeed(speed);
		setMaker(maker);
		setEngine(engine);
	}

	public int getSpeed() {
		return speed;
	}
	public String getMaker() {
		return maker;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String toString() {
		String info = "<< Car information>>\n";
		info += "speed : " + speed + "\n";
		info += "maker : " + maker + "\n";
		info += "engine : " + engine;
		return info;
	}
}
class CarTest {
	public static void main(String[] args) {
		Engine engine = new Engine(5000, 350.0, "Benz");
		Car car = new Car(300, "¸£»ï", engine);
		System.out.println(car);
	}
}
