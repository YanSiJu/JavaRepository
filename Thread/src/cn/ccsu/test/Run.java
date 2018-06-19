package cn.ccsu.test;

public class Run {

	
	public static void main(String...args) throws InterruptedException{
		
		MyThread run = new MyThread();
		Thread t = new Thread(run);
		t.start();
		Thread.sleep(2000);
		t.interrupt();
		
		System.out.println(t.isInterrupted());
	}
}
