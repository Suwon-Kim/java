package com.jang.board;

import java.util.UUID;

public class UploadClass {
	
	//첨부한 파일명을 받아서 확장자만 리턴, //스트링으로 넘어오는 파일명이 fileName
	//static 붙이면 다른곳에서 사용할때 객체를 만들필요가 없음
	public static String getExt(String fileName){
		//abcdef.jps => .jpg
		//adc.def.png => .png
		
		int last = fileName.lastIndexOf(".");
//		 "unhappy".substring(2) returns "happy"
//		 "Harbison".substring(3) returns "bison"
//		 "emptiness".substring(9) returns "" (an empty string)
		return fileName.substring(last);
	
	}
		//UUID는 스택틱 클래스(문자 아무거나 랜덤으로 나오게함), toString쓰면 문자로 바꿈, replaceAll( ) <-안에것을 변경시킨다는뜻
		//ex)123213123123123<--타임스탬프 asdasdasdsa-djasldkajkldasjldk
		public static String getUUid(){
			//replaceAll asdsad-sadads 사이에 - 제거
			String tmp = UUID.randomUUID().toString().replaceAll("-", "");
			//중복이 된다면 System.currentTimeMillis()+를 이용해서 시간을줘서 중복을 제거,타임스탬프
			return System.currentTimeMillis()+tmp;
		}
	
	
}