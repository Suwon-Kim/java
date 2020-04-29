/*
	예외상황 정의
*/
class TooLongArraySizeException extends Exception {
	public TooLongArraySizeException() {
		super("3개를 초과할 수 없습니다.");
	}
	public TooLongArraySizeException(int validCount) {
		super(validCount + "개를 초과할 수 없습니다.");
	}
}

class ExceptionEx3 {
	public static void printSum(int... nums) 
		throws TooLongArraySizeException {
		int count = 5;
		// 나는 원소가 3개를 초과하는 걸 원치않는다.
		// 배열의 길이가 3초과면 예외로 판정한다.
		if(nums.length > count) {
			// 예외가 발생하는 상황

			// 1. 예외객체 정의
			TooLongArraySizeException e = 
				new TooLongArraySizeException(count);
			// 2. 발생
			throw e;
		} else {
			int sum = 0;
			for(int n : nums) {
				sum += n;
			}
			System.out.println(sum);
		}
	}
	public static void main(String[] args)	{
		try {
			printSum(1,2,3);
		} catch(TooLongArraySizeException e) {
			System.out.println(e.getMessage());
		}

		try {
			printSum(1,2,3,4,5,6,7);
		} catch(TooLongArraySizeException e) {
			System.out.println(e.getMessage());
		}
	}
}
