class Some {
	int num;		// �������
}
class UseSome {
	public static void main(String[] args) {
		Some s1 = new Some();	// ��ü����
		s1.num = 30;
		
		Some s2 = new Some();
		s2.num = 15;

		System.out.println(s1.num);
		System.out.println(s2.num);
	}
}
