package cn.csu.collection;

import java.util.Deque;
import java.util.LinkedList;

public class Queue<E> {

	public Queue() {

	}

	private Deque<E> queue = new LinkedList<>();

	// 将元素e插入到队尾
	public boolean offer(E e) {
		return queue.offer(e);
	}

	// 删除队头元素
	public E poll() {
		return queue.poll();
	}

	// 返回队头元素
	public E peek() {
		return queue.peek();
	}

	// 返回队尾元素
	public E peekLast() {
		return queue.peekLast();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int size() {
		return queue.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queue<?> other = (Queue<?>) obj;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		return true;
	}

}
