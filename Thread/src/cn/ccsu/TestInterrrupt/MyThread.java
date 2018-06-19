package cn.ccsu.TestInterrrupt;

public class MyThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// ÿ��һ�����Ƿ��������жϱ�ʾ
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread is running...");
//			long time = System.currentTimeMillis();
			// ʹ��whileѭ��ģ�� sleep
		/*	while ((System.currentTimeMillis() - time < 1000)) {
			}*/
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("\n"+Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println("\n"+Thread.currentThread().isInterrupted());
			}
		}
		System.out.println("Thread exiting under request...");
	}

}
