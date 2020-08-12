package org.green.diTest;

import org.springframework.stereotype.Component;

/*
 * Annotation
 * 		@Component : bean으로 등록 (파일에 S가 생김) ,,  XML로 등록은 roo-context.xml로 들어가서 
 * 		<bean id = "mySome" class = "org.green.diTest.Some" />	<!-- 기본 생성자 없으면 에러  -->
 * 
 * 		@Controller > 서비스를 호출해줌 
 * 		@Repository > DAO 값을 주고 받고 함
 * 		@Serveice   > 기능 여러개를 묶어 놓은거임 Command객체라고 생각 실제 기능을 담당 
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
