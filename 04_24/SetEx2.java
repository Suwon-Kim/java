import java.util.*;
class SetEx2 {
	public static void main(String[] args)	{
		// 1 ~ 45 ³­¼ö
		Set<Integer> set = new TreeSet<Integer>();

		while(set.size() != 6) {
			set.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(set);
	}
}
