package cn.csu.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapThread extends Thread {

	public HashMapThread() {

	}

	public HashMapThread(Runnable target) {
		super(target);
	}

	public HashMapThread(String name) {
		super(name);
	}

	public HashMapThread(ThreadGroup group, Runnable target) {
		super(group, target);
	}

	public HashMapThread(ThreadGroup group, String name) {
		super(group, name);
	}

	public HashMapThread(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public HashMapThread(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
	}

	public HashMapThread(ThreadGroup group, Runnable target, String name, long stackSize) {
		super(group, target, name, stackSize);
	}

	private static AtomicInteger ai = new AtomicInteger(0);

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(1);

	public void run()

	{

		while (ai.get() < 100000)

		{

			map.put(ai.get(), ai.get());

			ai.incrementAndGet();

		}

	}

	public static void main(String[] args)

	{

		HashMapThread hmt0 = new HashMapThread();

		HashMapThread hmt1 = new HashMapThread();

		HashMapThread hmt2 = new HashMapThread();

		HashMapThread hmt3 = new HashMapThread();

		HashMapThread hmt4 = new HashMapThread();

		hmt0.start();

		hmt1.start();

		hmt2.start();

		hmt3.start();

		hmt4.start();

	}

}
