interface IEatable {
}
abstract class Fruits implements IEatable {
}
// Mark Interface
interface ILove {
}
class Banana extends Fruits implements ILove {
}
class Apple extends Fruits {
}
class Kiwi extends Fruits {
}
class Meat implements IEatable, ILove {
}
class Boy {
	public void eat(IEatable f) {
		/* 
			¹Ù³ª³ª -> ½ä¾î¸Ô´Â´Ù
			»ç°ú -> ±¸¿ö¸Ô´Â´Ù
			Å°À§ -> ²®ÁúÃ¤ ¸Ô´Â´Ù
			°í±â -> »ýÀ¸·Î ¸Ô´Â´Ù.
		*/
		if(f instanceof Fruits) {
			System.out.println("???");
		} else if(f instanceof Banana) {
			System.out.println("½ä¾î¸Ô´Â´Ù.");
		} else if(f instanceof Apple) {
			System.out.println("±¸¿ö¸Ô´Â´Ù.");
		} else if(f instanceof Kiwi) {
			System.out.println("²®ÁúÃ¤ ¸Ô´Â´Ù.");
		} else if(f instanceof Meat) {
			System.out.println("»ýÀ¸·Î ¸Ô´Â´Ù.");
		}
	}
}
class Girl {
	public void eat(ILove something) {
	}
}
class UseBoy {
	public static void main(String[] args) {
		Boy b = new Boy();
		b.eat(new Banana());
		b.eat(new Apple());
		b.eat(new Kiwi());
		b.eat(new Meat());

		Girl g = new Girl();
		g.eat(new Banana());
		g.eat(new Meat());
	}
}
