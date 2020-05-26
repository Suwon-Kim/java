package kr.ac.green;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx6 {
	public static void main(String[] args) {
		File dir = new File("c:");
		File[] list = dir.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy.MM.dd(a hh:MM:ss)"
		);				
		Date date = new Date();
		for(File temp : list) {
			String name = temp.getName();
			date.setTime(temp.lastModified());
			if(temp.isDirectory()) {
				name = "[ " + name + " ]";
			} else {
				long size = temp.length();
				date.setTime(temp.lastModified());
				name += "\t" + sdf.format(date) + "\t" + (size/1024) + "kbytes";
			}
			System.out.println(name);
		}
	}
}
