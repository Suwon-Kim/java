import java.util.*;
class MapEx2 {
	public static void main(String[] args)	{
		Map<String, String> map = new Hashtable<String, String>();
		
		// 원소 추가(key, value)
		map.put("IU", "010-1004-1004");
		map.put("에일리", "010-1004-5858");
		map.put("윤아", "010-5858-1004");
		map.put("이미자", "010-1577-1577");
		map.put("승미", "010-1234-1234");
		map.put("승민", "010-4321-4321");
		
		// 1. 모든 key를 가져온다
		Set<String> keys = map.keySet();
		// 2. key를 하나씩 꺼낸다
		for(String key : keys) {
			// 3. key에 맵핑된 value를 가져온다.
			String value = map.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
	}
}
