import java.util.*;

class MyKey {
	private int num;

	public MyKey(int num) {
		setNum(num);
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Mykey(" + num + ")";
	}		

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof MyKey)) {
			return false;
		}
		if(hashCode() != o.hashCode()) {
			return false;
		}
		MyKey key = (MyKey)o;
		return num == key.getNum();
	}
	/*
		a.equals(b) == true
		이면 반드시
		a.hashCode() == b.hashCode()
		이어야 한다. 단, 역은 성립하지 않는다.
	*/
	@Override
	public int hashCode() {
		// int -> String
		String strNum = String.valueOf(num);
		/*
			String -> int
		*/
		int n = Integer.parseInt(strNum);
		return	strNum.hashCode();
	}
}

class MapEx3 {
	public static void main(String[] args)	{
		HashMap<MyKey, String> map = new HashMap<MyKey, String>();
		// hashCode() 결과값
		map.put(new MyKey(4), "A");		// 1
		map.put(new MyKey(3), "B");		// 0
		map.put(new MyKey(8), "C");		// 2
		map.put(new MyKey(1), "D");		// 1
		map.put(new MyKey(2), "E");		// 2	
		map.put(new MyKey(9), "F");		// 0
		
		System.out.println("before : " + map.size());
		
		map.remove(new MyKey(4));		// 1

		System.out.println("after : " + map.size());
	}
}
