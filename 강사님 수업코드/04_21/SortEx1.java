/*
	Arrays
		-> �迭�� �� �� �ִ� ������� ����(static)
	����
		1. ��������
		2. ��������
*/
import java.util.Arrays;

class SortEx1 {
	public static void main(String[] args)	{
		int[] arr = {4, 1, 6, 9, 3, 7};

		// ������ ������..
		Arrays.sort(arr);

		String str = Arrays.toString(arr);
		System.out.println(str);
	}
}
