class ExceptionEx4 {
	public static void main(String[] args)	{
		try {
			int num = 0;
			while(true) {
				num++;
				if(num == 100) {
					throw new Exception();
				}
			}
		} catch(Exception e) {
			System.out.println("end");
		}
	}
}
