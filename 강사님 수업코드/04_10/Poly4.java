abstract class Unit {
	public abstract void sound();
}
class Zealot extends Unit {
	@Override
	public void sound() {
		System.out.println("마이 라이프 포 아이어~");
	}
}
class Mutal extends Unit {
	@Override
	public void sound() {
		System.out.println("끼야악~~");
	}
}
class Medic extends Unit {
	@Override
	public void sound() {
		System.out.println("hi~");
	}
}
class Poly4 {
	public static void makeSound(Unit unit) {
		unit.sound();
	}
	public static void main(String[] args) {
		makeSound(new Zealot());
		makeSound(new Mutal());
		makeSound(new Medic());
	}
}
