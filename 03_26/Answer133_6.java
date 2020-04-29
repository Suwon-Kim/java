/*
	- 2 ~ 100 사이 소수 찾기

	1. 2 ~ 100 : num
	2.	num	:	divider ( 2 ~ num-1)
		5	: 2,3,4
		6	: 2,3,4,5
		7	: 2,3,4,5,6
		100	: 2,3,4,5,6...99
*/
class Answer133_6 {
	public static void main(String[] args) {
		int count = 0;
		for(int num=2; num<=100; num++) {
			// num : 2 ~ 100
			boolean isPrime = true;
			for(int divider=2; isPrime && divider<=(num/2); divider++) {
				// divider : 2 ~ (num - 1)
				if(num % divider == 0) {
					// num는 소수가 아님
					isPrime = false;
				}
				count++;
			}
			// 소수면 출력
			if(isPrime) {
				System.out.println(num);
			}
		}
		System.out.println("반복횟수 : " + count); 
	} 
}
