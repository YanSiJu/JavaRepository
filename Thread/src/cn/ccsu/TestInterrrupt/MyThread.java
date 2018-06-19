package cn.ccsu.TestInterrrupt;

public class MyThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		// 每隔一秒检测是否设置了中断标示
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Thread is running...");
//			long time = System.currentTimeMillis();
			// 使用while循环模拟 sleep
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
