package cn.csu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {
	// private static volatile CopyOnWriteArrayList<Integer> list = new
	// CopyOnWriteArrayList<>();
	private static List<Integer> list = new ArrayList<>();

	/**
	 * @desc:线程one迭代list
	 * @Project:test
	 * @file:FailFastTest.java
	 * @Authro:chenssy
	 * @data:2014年7月26日
	 */
	private static class threadOne extends Thread {
		public void run() {
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				int i;
				// synchronized (list) {
				// i = iterator.next();
				// }

				i = iterator.next();
				System.out.println("ThreadOne 遍历:" + i);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @desc:当i == 3时，修改list
	 * @Project:test
	 * @file:FailFastTest.java
	 * @Authro:chenssy
	 * @data:2014年7月26日
	 */
	@SuppressWarnings("unused")
	private static class threadTwo extends Thread {
		public void run() {
			int i = 0;
			while (i < 6) {
				System.out.println("ThreadTwo run：" + i);
				// synchronized (list) {
				// if (i == 3) {
				// list.remove(i);
				// }
				// }

				if (i == 3) {
					list.remove(i);
				}
				i++;
			}
		}
	}

	private static class threadThree extends Thread {

		@Override
		public void run() {
			Iterator<Integer> it = list.iterator();
			Integer n = 3;
			while (it.hasNext()) {
				Integer x = it.next();
				if (n.equals(x)) {
					it.remove();
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		new threadOne().start();
		// new threadTwo().start();
		new threadThree().start();
	}

	// @Test
	// public void failFastWithSingleThread() {
	// List<Integer> lst = new ArrayList<>();
	// for (int i = 0; i < 10; i++) {
	// lst.add(i);
	// }
	//
	// Iterator<Integer> iterator = lst.iterator();
	// while (iterator.hasNext()) {
	// int i = iterator.next();
	// System.out.println("ThreadOne 遍历:" + i);
	// if (i == 3) {
	// lst.remove(i);
	// }
	// try {
	// Thread.sleep(10);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// }

}
