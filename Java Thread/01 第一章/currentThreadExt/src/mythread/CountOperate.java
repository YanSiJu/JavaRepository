package mythread;

public class CountOperate extends Thread {

	public CountOperate() {
		System.out.println("\nCountOperate---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("CountOperate---end\n\n");
	}

	@Override
	synchronized public void run() {
		System.out.println("\nrun---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()=" + this.getName());
		System.out.println("run---end\n");
	}

}
