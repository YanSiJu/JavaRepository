package cn.ccsu.thread;

public class MyThread2 extends Thread {

	public MyThread2() {

		System.out.println("��������ʼ====");
		/*System.out.println("this:"+this);
		System.out.println("Thread.currentThread():"+Thread.currentThread());*/
		System.out.println("this.getName():" + this.getName());
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());

		System.out.println("����������====\n");
	}

	@Override
	public synchronized void run() {

		System.out.println("\nrun��ʼ====");

		/*System.out.println("this:"+this);
		System.out.println("Thread.currentThread():"+Thread.currentThread()+"\n");*/
		
		System.out.println("this.getName():" + this.getName());
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());

		System.out.println("run����====\n");

	}

}
