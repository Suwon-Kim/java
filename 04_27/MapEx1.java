import java.util.*;
class MapEx1 {
	public static void main(String[] args)	{
		Map<String, String> map = new Hashtable<String, String>();
		
		// 원소 추가(key, value)
		map.put("IU", "010-1004-1004");
		map.put("에일리", "010-1004-5858");
		map.put("윤아", "010-5858-1004");
		map.put("이미자", "010-1577-1577");
		map.put("승미", "010-1234-1234");
		map.put("승민", "010-4321-4321");
		
		String key = "IU";
		// key의 존재유무확인
		if(!map.containsKey(key)) {
			map.put(key, "010-5858-5858");
		}

		// value의 존재유무확인
		System.out.println(map.containsValue("010-4321-4321"));

		System.out.println(map);

		// 원소 접근(key)
		String tel = map.get("IU");
		System.out.println(tel);
		
		map.remove("이미자");
		
		// 삭제(key를 이용)
		System.out.println(map);

		// 원소 수 구하기
		System.out.println(map.size());

		// 키만 가져오기
		Set<String> keys = map.keySet();
		System.out.println(keys);

		// value만 가져오기
		Collection<String> values = map.values();
		System.out.println(values);
	}
}
