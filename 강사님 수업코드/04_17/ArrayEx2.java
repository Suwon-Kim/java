class CalcResult {
	private int sum;
	private int multi;
	
	public CalcResult(int sum, int multi) {
		setSum(sum);
		setMulti(multi);
	}

	public int getSum() {
		return sum;
	}
	public int getMulti() {
		return multi;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public void setMulti(int multi) {
		this.multi = multi;
	}
}
class ArrayEx2 {
	public static void printSum(int n, int m) {
		System.out.println(n + m);
	}
	/*
		�Ķ���͸� �迭�� ������ ���
		-> ���������� ���� ������ ������ �� �ִ�.
	*/
	public static void newPrintSum(int[] someArr) {
		int sum = 0;
		for(int n : someArr) {
			sum += n;
		}
		System.out.println(sum);
	}
	/*
		�������� �迭�� ����� ���
		-> 0 or 1�� ���� -> �ǹ̻� �������� ���� ������ �� �ִ�.
	*/
	public static int[] makeIntArr(int length) {
		return new int[length];
	}

	/*
		�� ���� �Է¹޾Ƽ� �հ� ���� ����
	*/
	public static int[] process(int n, int m) {
		int[] result = {n+m, n*m};
		return result;
	}
	
	public static CalcResult newProcess(int n, int m) {
		return new CalcResult(n+m, n*m);
	}

	public static final int SUM = 0;
	public static final int MUTI = 1;
	public static void main(String[] args)	{
		CalcResult obj = newProcess(5, 7);
		System.out.println(obj.getSum());
		System.out.println(obj.getMulti());
		

		int[] result = process(5, 4);
		System.out.println(result[SUM]);
		System.out.println(result[MUTI]);

		/*
		int[] myArr = makeIntArr(3);
		myArr[0] = 4;
		myArr[1] = 2;
		myArr[2] = 100;
		
		newPrintSum(myArr);

		/*
		int[] arr = {1,2,3,4,5,6,7};
		newPrintSum(arr);
		newPrintSum(new int[]{1,2,3});
		*/
	}
}
