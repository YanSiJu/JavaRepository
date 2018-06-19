package cn.ccsu.concurrent.pool;

public class MyTask implements Runnable {

	@SuppressWarnings("unused")
	private int taskNum;
	private static int count = 0;

	public MyTask(int num) {
		this.taskNum = num;
	}

	@Override
	synchronized public void run() {

		System.out.println(Thread.currentThread().getName() + " 正在执行");
		/*
		 * try { Thread.sleep(500); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println("count:" + (++count) +"  "+ Thread.currentThread().getName() + " 执行完毕");
	}

}
