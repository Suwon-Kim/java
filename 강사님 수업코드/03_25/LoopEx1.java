class LoopEx1 {
	public static void main(String[] args) {
		/*
			1 ~ 1000����, Ȧ��, �� ��
				-> divide and conquer

			Ȧ�� 
				- 2�γ��� �������� 0�� �ƴѼ�
				- 1,3,5,7,9 ....
		*/
		int sum = 0;
		int num = 1;
		while(num <= 1000) {
			sum += num;
			num += 2;
		}
		/*
		while(num <= 1000) {
			if(num % 2 != 0) {
				sum += num;
			}
			num++;
		}
		*/
		System.out.println(sum);
	}
}





















