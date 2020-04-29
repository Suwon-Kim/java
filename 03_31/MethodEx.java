/*
	메서드 구분 기준
	1. 이름
	2. 파라미터 정보(갯수, 타입, 순서)

	구분기준이 아닌것
	1. 리턴정보
	2. 접근제한자
*/
class MethodEx {
	public void todo() {
	}	
	void todo(int n) {
	}
	
	void todo(String str) {
	}
	void todo(int n, String str) {
	}
	void todo(String str, int n) {
	}
}
