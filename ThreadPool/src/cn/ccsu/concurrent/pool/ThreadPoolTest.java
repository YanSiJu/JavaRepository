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
		 * System.out.println("�̳߳����߳���Ŀ��" + + "�������еȴ�ִ�е�������Ŀ��" +
		 * executor.getQueue().size() + "����ִ������������Ŀ��" +
		 * executor.getCompletedTaskCount());
		 */
		
		
		pool.shutdown();

	}

	public ThreadPoolTest() {

	}

}
