package ppt.ppt14;


public class TestThread {
	static public class MyRunnable2 implements Runnable {

		private String myName;

		public MyRunnable2(String string) {
			this.myName = string;
		}

		@Override
		public void run() {
			for (int i = 10; i >= 0; i--)
				System.out.print(myName + i + " ");
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable2("A"));
		Thread t2 = new Thread(new MyRunnable2("B"));
		t1.start();
		t2.start();
	}

}