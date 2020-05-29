package kr.ac.green;

import java.io.FileReader;
import java.io.IOException;

public class Member {
	private String id;
	private String password;
	private String name;
	private String nickName;
	
	public static void readFromFile() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("C:\\Users\\user\\Desktop\\memberInfo.text");
			int data = -1;
			while( (data = fr.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fr);
		}
	}
	public String getId() {
		return id;	
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
