import java.util.*;
class MapEx2 {
	public static void main(String[] args)	{
		Map<String, String> map = new Hashtable<String, String>();
		
		// ���� �߰�(key, value)
		map.put("IU", "010-1004-1004");
		map.put("���ϸ�", "010-1004-5858");
		map.put("����", "010-5858-1004");
		map.put("�̹���", "010-1577-1577");
		map.put("�¹�", "010-1234-1234");
		map.put("�¹�", "010-4321-4321");
		
		// 1. ��� key�� �����´�
		Set<String> keys = map.keySet();
		// 2. key�� �ϳ��� ������
		for(String key : keys) {
			// 3. key�� ���ε� value�� �����´�.
			String value = map.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
	}
}
