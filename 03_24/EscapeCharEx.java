/*
	escape character : \

	\n : 줄바꿈
	\" : 글자 "
	\t : tab
	\\ : 글자 \
		"C:\Program Files\Java\jdk1.8.0_241"
	"hello" -> String
*/

class EscapeCharEx {
	public static void main(String[] args) {
		// 아버지가 "나가" 라고 하셨다.
		System.out.println("아버지가 \"나가\" 라고 하\n셨다.");
		System.out.println("C:\\Program Files\\Java\\jdk1.8.0_241");
	}
}
