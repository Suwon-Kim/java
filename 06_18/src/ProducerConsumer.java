public class ProducerConsumer{
	public static void main(String[] args){
		MyBox c = new MyBox();
		Producer p1 = new Producer(c);
		Consumer c1 = new Consumer(c);
		Consumer c2 = new Consumer(c);
		
		p1.start();
		c1.start();
		c2.start();
	}
}
class Producer extends Thread{
	private MyBox box;
	public Producer(MyBox box){
		this.box = box;
	}
	public void run(){
		for(int i =0; i<20; i++){
			box.put(i);
			try{
				sleep(100);
			}catch (InterruptedException e) {}
		}
	}
}

class Consumer extends Thread{
	private MyBox box;
	public Consumer(MyBox c){
		box = c;
	}
	public void run(){
		int value = 0;
		for(int i=0; i<10; i++){
			box.get();
			try{
				sleep(100);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

class MyBox {
	private int contents;
	private boolean isEmpty =true;
	public void get(){
		if(!isEmpty){
			isEmpty = !isEmpty;
			System.out.println(
					Thread.currentThread().getName()+
					": �Һ�" + contents
			);
		}
	}
	public void put(int value){
		if(isEmpty){
			contents= value;
			System.out.println(
					Thread.currentThread().getName()+
					": ����" + value	
			);
			isEmpty = ! isEmpty;
		}
	}
}