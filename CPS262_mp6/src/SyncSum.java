
public class SyncSum implements Runnable{
	
	int sum;
	
	public SyncSum() {
		sum = 0;
	}
	
//	public synchronized void increaseSum() {
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {}
//		System.out.println(Thread.currentThread().getName() + " sum is: " + (++sum));
//	}
	
	public void increaseSum() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			synchronized(this){
				System.out.println(Thread.currentThread().getName() + " sum is: " + (++sum));
			}
	}
	
	public void run() {
		increaseSum();
	}

	public static void main(String[] args) {
		SyncSum s = new SyncSum();
		
		for(int i = 1; i < 101; i++) {
			Thread t = new Thread(s);
			t.start();
		}

		

	}

}
