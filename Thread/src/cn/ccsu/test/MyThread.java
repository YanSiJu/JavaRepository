package cn.ccsu.test;

public class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			if (this.isInterrupted()) {
				System.out.println("Õ£÷π¡À!  " + this.isInterrupted());
				return;
			}
			System.out.println(Thread.currentThread().isInterrupted());
//			System.out.println("timer=" + System.currentTimeMillis());
		}
	}

}
