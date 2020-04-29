interface IMachine {
	void turnOn();
	void turnOff();
}

class Tv implements IMachine {
	@Override
	public void turnOn() {
		System.out.println("turn on TV");
	}
	@Override
	public void turnOff() {
		System.out.println("turn off TV");
	}
}
class Radio implements IMachine {
	@Override
	public void turnOn() {
		System.out.println("turn on RADIO");
	}
	@Override
	public void turnOff() {
		System.out.println("turn off RADIO");
	}
}

class Server {
	public void performTurnOn(IMachine m) {
		m.turnOn();
	}
	public void performTurnOff(IMachine m) {
		m.turnOff();
	}
}

class ServerTest {
	public static void main(String[] args) {
		Server server = new Server();
		Tv tv = new Tv();
		Radio radio = new Radio();

		server.performTurnOn(tv);
		server.performTurnOn(radio);

		server.performTurnOff(tv);
		server.performTurnOff(radio);
	}
}
