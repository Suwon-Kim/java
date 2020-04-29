class StringEx {
	public static void main(String[] args) {
		String str1 = "abc";		// "abc"
		String str2 = new String("abc");	// "abc"

		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
	}
}
