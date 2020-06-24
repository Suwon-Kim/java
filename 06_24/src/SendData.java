import java.io.Serializable;
//여기서 구분을 짓는 역할을 해주는게 opcode 어떤일을 해야하는지를 알려주는 구분자 역할 opcode (물약을 마신다)
//op1 물약의 양, op2 현재 체력 등등 
//프로토콜 설계 제일먼저 (해야할 게 해야되는게 많아지면 많아질 수록) 이런거에 대한 예저를 하나 던져준 파일임
public class SendData implements Serializable {
	private int op1;
	private int op2;
	private String opcode;
	
	public SendData(int op1, int op2, String opcode) {
		this.op1 = op1;
		this.op2 = op2;
		this.opcode = opcode;
	}
	public int getOp1() {
		return op1;
	}
	public int getOp2() {
		return op2;
	}
	public String getOpcode() {
		return opcode;
	}
}
