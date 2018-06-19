package cnccsu.test;

public class TestMyThread {

	
	public static void main(String[] args){
		
		MyThread run=  new MyThread();
		
		Thread t0 = new Thread(run);
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		Thread t5 = new Thread(run);
		
		
		t1.start();
		t0.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
		
		
//		System.out.println("END!!");		
//		t.run();
		
	}
}
