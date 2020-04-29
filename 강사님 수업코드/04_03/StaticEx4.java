class StaticEx4 {
	public static void methodStatic() {
		methodNonstatic();
	}
	public void methodNonstatic() {
		methodStatic();
	}	
}
