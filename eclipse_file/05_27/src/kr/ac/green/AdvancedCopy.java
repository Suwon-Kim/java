package kr.ac.green;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static kr.ac.green.MyUtils.*;
//���ϱ� �Ѵ� �Ѱ��� �Ἥ �������� ���������� �ҷ��� �� �׳� �޼ҵ� �̸��� ������ ������ ��� ���Դ��� �� ���� ����. �ִµ� �������� 
//-- > ������ƿ������ �͵��� ���� ó�� �� �� �ִ�. finally�� MyUtils�� ���� �� �� �ִ�.
public class AdvancedCopy {

	public static void newCopy() {
		File src = new File("c:\\dev\\eclipse.zip");
		File copy = new File("c:\\dev\\copy.zip");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		long time = System.currentTimeMillis();
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(copy);
			
			int count = -1;
			//5õ ����Ʈ�� �д´�.
			byte[] buffer = new byte[5000];
			 
			while( (count = fis.read(buffer)) != -1 ) {
				fos.write(buffer, 0, count);
				//�о ���ۿ� ä���� �� 
				//count = ���� ����Ʈ �� 
				//5õ ����Ʈ �� ī��Ʈ�� ���
			}
			time = System.currentTimeMillis() - time;
			System.out.println(time + "ms");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MyUtils.closeAll(fis, fos);
		}
	}	
	public static void main(String[] args) {		
		newCopy();
	}
}





