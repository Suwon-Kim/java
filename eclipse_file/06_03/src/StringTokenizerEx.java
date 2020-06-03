import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String str = "동해물과 ,백두산이@마르고 :닳도록, 하느님이, 보우하사, 우리 ,나라 ,만세";
		
		//기본적으로 Space, enter, tap을 인식해서 구분해주고 끊어준다.
		//하나씩 끊어낸것을 토큰이라 한다.
		StringTokenizer st = new StringTokenizer(str, ",@:"); // 2번째 파라미터로 ","들어가면 ,를 구분한다.
		//2번째 파라미터로 @:를 적어주면 저것도 구분한다.
		while(st.hasMoreTokens()) {
		//토큰이 더 있습니까 ? 
			System.out.println(st.nextToken());
		}
	}
}
