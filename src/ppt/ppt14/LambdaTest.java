package ppt.ppt14;

public class LambdaTest{
	public static void main(String args[]) {
//		
//		Runnable task = () -> {
//			for (int i = 10; i >= 0; i--)
//				System.out.print(i + " ");
//		};
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 10; i >= 0; i--) {
					try {
						Thread.sleep(1000);
						System.out.print(i + " ");
						if(i==5) {
							System.out.println("여기까지");
							//Thread.currentThread().stop();
							Thread.currentThread().interrupt();
						}
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		};
		new Thread(task).start();
	}
}