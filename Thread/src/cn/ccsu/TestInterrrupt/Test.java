package cn.ccsu.TestInterrrupt;

public class Test {

	public static void main(String args[]) throws Exception {
		
		MyThread run = new MyThread();
		Thread thread = new Thread(run);
		
		System.out.println("Starting thread...");
		thread.start();
		
		Thread.sleep(3000);
		System.out.println("Asking thread to stop...");
		// �����ж�����
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		
	}
}
