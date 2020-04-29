class Unit {
	private int hp;	// 100
	public Unit(int hp) {
		this.hp = hp;
	}
	public Unit() {
		hp = 300;
	}
	public String toString() {
		return "hp : " + hp;
	}
}
class Zealot extends Unit {
	private int power; // 11
	public Zealot(int hp, int power) {
		super(hp);
		this.power = power;
	}
	public Zealot(int power) {
		super(200);
		this.power = power;
	}
	public Zealot() {		
		this.power = 15;
	}
	public String toString() {
		String info = super.toString() + "\n";
		info += "power : " + power;
		return info;
	}
}
class Ex5 {
	public static void main(String[] args) {
		System.out.println(new Zealot(100, 11));
		System.out.println(new Zealot(20));
	}
}

