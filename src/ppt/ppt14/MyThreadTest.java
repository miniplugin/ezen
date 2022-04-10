package ppt.ppt14;
class MyThread2 extends Thread {
	public void run() {
		for (int i = 10; i >= 0; i--)
			System.out.print(i + " ");
	}
}

public class MyThreadTest {
	public static void main(String args[]) {

		Thread t = new MyThread2();
		t.start();
	}
}