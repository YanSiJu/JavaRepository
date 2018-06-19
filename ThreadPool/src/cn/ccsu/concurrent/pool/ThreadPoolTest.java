package cn.ccsu.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newCachedThreadPool();
		int taskNum = 10;

		for (int i = 0; i < taskNum; i++) {

			pool.submit(new MyTask(i));
		}
		/*
		 * System.out.println("线程池中线程数目：" + + "，队列中等待执行的任务数目：" +
		 * executor.getQueue().size() + "，已执行玩别的任务数目：" +
		 * executor.getCompletedTaskCount());
		 */
		
		
		pool.shutdown();

	}

	public ThreadPoolTest() {

	}

}
