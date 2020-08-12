package org.green.diTest;

import org.springframework.stereotype.Component;

/*
 * Annotation
 * 		@Component : bean���� ��� (���Ͽ� S�� ����) ,,  XML�� ����� roo-context.xml�� ���� 
 * 		<bean id = "mySome" class = "org.green.diTest.Some" />	<!-- �⺻ ������ ������ ����  -->
 * 
 * 		@Controller > ���񽺸� ȣ������ 
 * 		@Repository > DAO ���� �ְ� �ް� ��
 * 		@Serveice   > ��� �������� ���� �������� Command��ü��� ���� ���� ����� ��� 
 */

public class Some {
	private String contents;

	public Some(String contents) {
		super();
		this.contents = contents;
	}
	
	public Some() {
		
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Some [contents=" + contents + "]";
	}

}
