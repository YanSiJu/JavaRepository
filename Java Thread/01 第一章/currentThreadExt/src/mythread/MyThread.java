package mythread;

public class MyThread extends Thread {
	public MyThread() {
		this.setName("a");
	}

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("this.getname:" + this.getName());
			System.out.println("currentThread():" + Thread.currentThread().getName() + " begin");
			System.out.println("currentThread():" + Thread.currentThread().getName() + " end");
		}
	}

	public static void main(String[] args) {
		MyThread m = new MyThread();
		m.start();
	}
}
