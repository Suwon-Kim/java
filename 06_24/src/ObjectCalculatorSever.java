
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectCalculatorSever {
	public static void main(String[] args) {
		Socket sock = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try{
			ServerSocket ss = new ServerSocket(10005);
			System.out.println("클라이언트의 접속을 대기합니다.");
			sock = ss.accept();
			
			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());
			Object obj = null;
			while((obj = ois.readObject()) != null){
				SendData sd = (SendData)obj;
				int op1 = sd.getOp1();
				int op2 = sd.getOp2();
				String opcode = sd.getOpcode();
				if(opcode.equals("+")){
					oos.writeObject(op1 + " + " + op2 + " = " + (op1 + op2));
				}else if(opcode.equals("-")){
					oos.writeObject(op1 + " - " + op2 + " = " + (op1 - op2));
				}else if(opcode.equals("*")){
					oos.writeObject(op1 + " * " + op2 + " = " + (op1 * op2));
				}else if(opcode.equals("%")){
					oos.writeObject(op1 + " % " + op2 + " = " + (op1 % op2));
				}else if(opcode.equals("/")){
					if(op2 == 0){
						oos.writeObject("0으로 나눌수 없습니다.");
					}else{
						oos.writeObject(op1 + " / " + op2 + " = " + (op1 / op2));
					}
				}// end if
				oos.flush();
				oos.reset();
				
				System.out.println("결과를 전송하였습니다.");
			}
			
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			try{
				if(oos != null) oos.close();
			}catch(Exception ex){}
			try{
				if(ois != null) ois.close();
			}catch(Exception ex){}
			try{
				if(sock != null) sock.close();
			}catch(Exception ex){}
		} // finally
	} // main
}
