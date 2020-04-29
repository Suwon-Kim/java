+00/*
		Dog
	============================
		name : String
		kind : String
		color : String
	============================
		bark() : void
		bite(what : String) : void
		eat(what : String) : void

*/
class Dog {
	String name;
	String kind;
	String color;

	String getInfo() {
		return name + "(" + kind + ", " + color + ")";
	}
	void bark() {
		System.out.println("멍멍멍~");
	}
	void bite(String what) {
		System.out.println(getInfo() + "이(가) " + what + "을(를) 물어요~");
	}
	void eat(String what) {
		System.out.println(getInfo() + "이(가) " + what + "을(를) 먹어요~");
	}
}
class Page157_7 {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.name = "바둑이";
		d.kind = "말티스";
		d.color = "흰색";

		d.bark();
		d.eat("소고기");
		d.bite("사람");
	}
}
