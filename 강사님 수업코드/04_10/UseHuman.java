class Clothes {
}
class Pants extends Clothes {
}
class Tshirts extends Clothes {
}
class Hat extends Clothes {
}
class Human {
	// Clothes c = new Tshirts()
	public void buy(Clothes c) {
	}	
}
class UseHuman {
	public static void main(String[] args) {
		Pants pants = new Pants();
		// Pants -> Clothes
		Clothes c = pants;
		Clothes c2 = new Pants();


		Human h = new Human();
		
		h.buy(pants);
		h.buy(new Tshirts());
		h.buy(new Hat());
	}
}
