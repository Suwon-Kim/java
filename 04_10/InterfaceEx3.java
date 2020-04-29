/*
	* 컴파일 안됌~ㅋㅋ
	~할 수 있다.
*/
interface IWalking {	
	void walk();
}
class Dead implements IWalking {
	
}
class Medic extends Unit implements IWalking {
}
class Zealot extends Unit implements IAttackable, IWalking {
	public void attack(IWalking target) {
	}
}
class Mutal extends Unit implements IAttackable, IFlying {
	public void attack(Unit target) {
	}
}

class InterfaceEx3 {
	public static void main(String[] args) {

	}
}
