class Answer1 {
	public static void main(String[] args) {
		for(int bae=1; bae<=9; bae++) {
			// bae : 1 ~ 9
			for(int dan=2; dan<=9; dan++) {
				// dan : 2 ~ 9
				System.out.printf("%d*%d=%d\t", dan, bae, (dan * bae));
			}
			System.out.println();
		}
	}
}
