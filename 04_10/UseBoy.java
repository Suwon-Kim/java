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
			�ٳ��� -> ���Դ´�
			��� -> �����Դ´�
			Ű�� -> ����ä �Դ´�
			���� -> ������ �Դ´�.
		*/
		if(f instanceof Fruits) {
			System.out.println("???");
		} else if(f instanceof Banana) {
			System.out.println("���Դ´�.");
		} else if(f instanceof Apple) {
			System.out.println("�����Դ´�.");
		} else if(f instanceof Kiwi) {
			System.out.println("����ä �Դ´�.");
		} else if(f instanceof Meat) {
			System.out.println("������ �Դ´�.");
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
