class MyPrinter {
	private boolean flag = true;
//	public synchronized void printContents() {
//		while(!flag) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			for(char c = 'a'; c<='z'; c++) {
//				System.out.print(c);
//			}
//			System.out.println();
//		}
//		flag = ! flag;
//		notifyAll();
//	}
	
	public synchronized void printContents() {
		while(flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(char c = 'a'; c<='z'; c++) {
			System.out.print(c);
		}
		System.out.println();
		flag = !flag;
		notifyAll();
	}
	
	public synchronized void marker() {
//		System.out.println("start printing");
//		while(flag) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("end printing");
//		}
//		flag = ! flag;
//		notifyAll();
		
		while(!flag) {
			try {
				wait();
				System.out.println("end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("start");
		flag = !flag;
		notifyAll();
	}
}
