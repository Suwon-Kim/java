import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		String str = "���ع��� ,��λ���@������ :�⵵��, �ϴ�����, �����ϻ�, �츮 ,���� ,����";
		
		//�⺻������ Space, enter, tap�� �ν��ؼ� �������ְ� �����ش�.
		//�ϳ��� ������� ��ū�̶� �Ѵ�.
		StringTokenizer st = new StringTokenizer(str, ",@:"); // 2��° �Ķ���ͷ� ","���� ,�� �����Ѵ�.
		//2��° �Ķ���ͷ� @:�� �����ָ� ���͵� �����Ѵ�.
		while(st.hasMoreTokens()) {
		//��ū�� �� �ֽ��ϱ� ? 
			System.out.println(st.nextToken());
		}
	}
}