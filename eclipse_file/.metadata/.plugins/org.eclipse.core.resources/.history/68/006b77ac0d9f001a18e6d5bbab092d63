package kr.ac.green;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeFormatting {
	public static void main(String[] args) {
		File f = new File("c:\\study\\a.txt");
		long time = f.lastModified();
		// 2020-05-26
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(hh:mm:ss)");	//포멧 결정
		// SimpleDateFormat이라는 클래스안의 표만 참고 하면 된다.
				
		Date today = new Date(); // 현재시간
		today.setTime(time);	 // 원하는 시간 설정 
		
		//시간 - > 문자열
		String strToday = sdf.format(today);
		//중요함 많이 쓴다 꼭 알고 있어야 한다. 
		
		try {
			//문자열 - > Date (시간) 단 "yyyy-MM-dd(hh:mm:ss)"형식으로 되어 있어야함
			Date newDate = sdf.parse(strToday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(strToday);
	}
}
