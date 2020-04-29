class HashCodeEx2 {
	public static void main(String[] args)	{
		/*
			String
			-> a.equals(b) 가 true인 경우
			-> a.hashCode() == b.hashCode()
		*/
		System.out.println("아반떼".hashCode());
		System.out.println("소나타".hashCode());
		System.out.println("아반떼".hashCode());
	}
}
