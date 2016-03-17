
// Answer4
import java.util.concurrent.*;

public class SequentialNumbers {

	private class PrintOne implements Runnable {
		private Semaphore first;
		private Semaphore second;
		
		public PrintOne(Semaphore first, Semaphore second) {
			this.first = first;
			this.second = second;
		}
	
		public void run() {
			while (true) {
				try {
					first.acquire();
					System.out.println("1");
					second.release();
				} catch (InterruptedException e) {
					e.printStackTrace();	
					break;
				}
			}
		}
	}

	private class PrintTwo implements Runnable {
		private Semaphore second;
		private Semaphore third;
		
		public PrintTwo(Semaphore second, Semaphore third) {
			this.second = second;
			this.third = third;
		}
	
		public void run() {
			while (true) {
				try {
					second.acquire();
					System.out.println("2");
					third.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	private class PrintThree implements Runnable {
		private Semaphore third;
		private Semaphore first;
		
		public PrintThree(Semaphore third, Semaphore first) {
			this.third = third;
			this.first = first;
		}
	
		public void run() {
			while (true) {
				try {
					third.acquire();
					System.out.println("3");
					first.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Semaphore first = new Semaphore(1);
		Semaphore second = new Semaphore(0);
		Semaphore third = new Semaphore(0);
		SequentialNumbers sn = new SequentialNumbers();
		Thread t1 = new Thread(sn.new PrintOne(first, second));
		Thread t2 = new Thread(sn.new PrintTwo(second, third));
		Thread t3 = new Thread(sn.new PrintThree(third, first));
		t1.start();
		t2.start();
		t3.start();
	}

}
