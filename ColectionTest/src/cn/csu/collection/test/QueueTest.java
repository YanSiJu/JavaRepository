package cn.csu.collection.test;

import cn.csu.collection.Queue;

public class QueueTest {

	public QueueTest() {

	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		for (String s : "My dog has fleas".split(" "))
			queue.offer(s);

		System.out.println("stack.peek():" + queue.peek());
		System.out.println("peekLast():" + queue.peekLast());

		while (!queue.isEmpty())
			System.out.print(queue.poll() + " ");
	}

}
