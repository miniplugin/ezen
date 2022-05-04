package ppt.ppt14;
public class ThreadA {
	public static void main(String[] args) throws InterruptedException {
		ThreadB b = new ThreadB();
		b.start();

		synchronized (b) {
			System.out.println("스레드 B가 종료되기를 기다림...");
			b.wait();
			System.out.println("전체 합계: " + b.total);
			b.stop();
			//b.interrupt();
		}
	}
}

class ThreadB extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {

			for (int i = 0; i < 1000; i++) {
				total += i;
			}
			try {
				//System.out.println("전체 합계: " + total);
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}