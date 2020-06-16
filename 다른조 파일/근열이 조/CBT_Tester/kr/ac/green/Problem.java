
import java.util.StringTokenizer;

import javax.swing.JTextField;
 class Problem {
	private int subjectNum;
	private String questionTitle1;
	private String questionTitle2;
	private String imageDir;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer5;
	private String result;
	private String myText;
	
	public Problem (
			int subjectNum,
			String questionTitle1,
			String questionTitle2,
			String imageDir,
			String answer1, 
			String answer2,
			String answer3,
			String answer4,
			String answer5,
			String result
			
			){
		
			this.subjectNum = subjectNum;
			this.questionTitle1 = questionTitle1;
			this.questionTitle2 = questionTitle2;
			this.imageDir = imageDir;
			this.answer1 = answer1;
			this.answer2 = answer2;
			this.answer3 = answer3;
			this.answer4 = answer4;
			this.answer5 = answer5;
			this.result = result;
			
	}
	
	public Problem (
			int subjectNum,
			String questionTitle1,
			String questionTitle2,
			String imageDir,
			String answer1, 
			String answer2,
			String answer3,
			String answer4,
			String answer5,
			String result,
			String myText){
			this.subjectNum = subjectNum;
			this.questionTitle1 = questionTitle1;
			this.questionTitle2 = questionTitle2;
			this.imageDir = imageDir;
			this.answer1 = answer1;
			this.answer2 = answer2;
			this.answer3 = answer3;
			this.answer4 = answer4;
			this.answer5 = answer5;
			this.result = result;
			this.myText = myText;
	}
	
	public int getSubjectNum() {
		return subjectNum;
	}
	public String getQuestionTitle1() {
		return questionTitle1;
	}
	public String getQuestionTitle2() {
		return questionTitle2;
	}
	public String getImageDir() {
		return imageDir;
	}
	public String getAnswer1() {
		return answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public String getResult() {
		return result;
	}
	public String getMyText() {
		return myText;
	}
	protected String[] textReturn() {
		String[] str = {
			getAnswer1(),
			getAnswer2(),
			getAnswer3(),
			getAnswer4(),
			getAnswer5()
		};
		
		return str; 
	}
	protected StringBuffer returnString() {
		StringBuffer sb = new StringBuffer();
		sb.append(subjectNum + "\n");
		sb.append(questionTitle1 + "\n");
		sb.append(questionTitle2 + "\n");
		sb.append(imageDir + "\n");
		sb.append(answer1 + "\n");
		sb.append(answer2 + "\n");
		sb.append(answer3 + "\n");
		sb.append(answer4 + "\n");
		sb.append(answer5 + "\n");
		sb.append(result+"\n");
		return sb;
	}
	
	@Override
	public String toString() {
		return "Problem [subjectNum=" + subjectNum + ", questionTitle1=" + questionTitle1 + ", questionTitle2="
				+ questionTitle2 + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3
				+ ", answer4=" + answer4 + ", answer5=" + answer5 + ", result=" + result + "]";
	}
}