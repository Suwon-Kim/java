class ScopeTest {
	public static void main(String[] args) {
		boolean flag = true;
		int n;
		if(flag) {
			n = 2;
		} else if(!flag) {
			n = 4;
		} else {
			n = 5;
		}
		System.out.println(n);
	}		
}
