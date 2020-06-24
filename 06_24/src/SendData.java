import java.io.Serializable;
//���⼭ ������ ���� ������ ���ִ°� opcode ����� �ؾ��ϴ����� �˷��ִ� ������ ���� opcode (������ ���Ŵ�)
//op1 ������ ��, op2 ���� ü�� ��� 
//�������� ���� ���ϸ��� (�ؾ��� �� �ؾߵǴ°� �������� ������ ����) �̷��ſ� ���� ������ �ϳ� ������ ������
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
