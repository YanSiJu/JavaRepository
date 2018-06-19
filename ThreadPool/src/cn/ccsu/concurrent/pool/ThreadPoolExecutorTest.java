package cn.ccsu.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ThreadPoolExecutorTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {
		System.out.println("----->start:"+System.nanoTime());
		System.out.println("\nThreadPoolExecutorTest");
		
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 14, 1000, TimeUnit.MINUTES,
				new LinkedBlockingQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());

		int taskNum = 20;
		int timeOut = 2000;
		pool.awaitTermination(timeOut, TimeUnit.MILLISECONDS);
		for (int i = 0; i < taskNum; i++) {
			@SuppressWarnings("unused")
			Future<?> f = pool.submit(new MyTask(i));
			// System.out.println(i+":"+f.get());
		}
		System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" + pool.getQueue().size() + "，已执行完的任务数目："
				+ pool.getCompletedTaskCount());

		pool.shutdown();
		System.out.println("----->end:"+System.nanoTime());
	}

}
