package cnccsu.test;

public class MyThread implements Runnable {

	private int count = 10;
	
	public MyThread() {

		System.out.println("¹¹ÔìÆ÷£º"+Thread.currentThread().getName());
	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		
		
		/*System.out.println("Start!!");
		System.out.println("run:£º"+Thread.currentThread().getName());*/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+":"+(--count));
		
	}


}
