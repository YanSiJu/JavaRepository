package cn.ccsu.thread;

public class MyThread2 extends Thread {

	public MyThread2() {

		System.out.println("构造器开始====");
		/*System.out.println("this:"+this);
		System.out.println("Thread.currentThread():"+Thread.currentThread());*/
		System.out.println("this.getName():" + this.getName());
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());

		System.out.println("构造器结束====\n");
	}

	@Override
	public synchronized void run() {

		System.out.println("\nrun开始====");

		/*System.out.println("this:"+this);
		System.out.println("Thread.currentThread():"+Thread.currentThread()+"\n");*/
		
		System.out.println("this.getName():" + this.getName());
		System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());

		System.out.println("run结束====\n");

	}

}
