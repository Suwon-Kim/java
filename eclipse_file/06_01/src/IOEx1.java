import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import kr.ac.green.MyUtils;

public class IOEx1 {
	public static void save() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("data.dat");
			dos = new DataOutputStream(fos);
			Random r = new Random();
			//3부터 49 까지 난수 
			int num = r.nextInt(50) + 3;
			for(int i = 0; i < num; i++) {
				dos.writeInt(3);
				dos.writeDouble(3.14);
				dos.writeBoolean(false);
				
			}
			dos.flush();
			System.out.println(num + "번 썼음");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(dos, fos);
		}
	}
	public static void load() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("data.dat");
			dis = new DataInputStream(fis);
			
			int count = 1;
			
			while(dis.available() > 0) {
				System.out.println("===========" + count + "===========");
				int n = dis.readInt();
				double d = dis.readDouble();
				boolean b = dis.readBoolean();
				System.out.println(n);
				System.out.println(d);
				System.out.println(b);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(dis, fis);
		}
	}
	public static void main(String[] args) {
		save();
		load();
	}
	
}
