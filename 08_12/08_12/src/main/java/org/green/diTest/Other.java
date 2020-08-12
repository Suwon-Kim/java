package org.green.diTest;

public class Other {
	private Some some;

	public Other() {
		super();
	}

	public Other(Some some) {
		super();
		this.some = some;
	}

	public Some getSome() {
		return some;
	}

	public void setSome(Some some) {
		this.some = some;
	}

	@Override
	public String toString() {
		return "Other [some=" + some + "]";
	}
}
