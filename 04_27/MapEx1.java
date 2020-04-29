import java.util.*;
class MapEx1 {
	public static void main(String[] args)	{
		Map<String, String> map = new Hashtable<String, String>();
		
		// ���� �߰�(key, value)
		map.put("IU", "010-1004-1004");
		map.put("���ϸ�", "010-1004-5858");
		map.put("����", "010-5858-1004");
		map.put("�̹���", "010-1577-1577");
		map.put("�¹�", "010-1234-1234");
		map.put("�¹�", "010-4321-4321");
		
		String key = "IU";
		// key�� ��������Ȯ��
		if(!map.containsKey(key)) {
			map.put(key, "010-5858-5858");
		}

		// value�� ��������Ȯ��
		System.out.println(map.containsValue("010-4321-4321"));

		System.out.println(map);

		// ���� ����(key)
		String tel = map.get("IU");
		System.out.println(tel);
		
		map.remove("�̹���");
		
		// ����(key�� �̿�)
		System.out.println(map);

		// ���� �� ���ϱ�
		System.out.println(map.size());

		// Ű�� ��������
		Set<String> keys = map.keySet();
		System.out.println(keys);

		// value�� ��������
		Collection<String> values = map.values();
		System.out.println(values);
	}
}
