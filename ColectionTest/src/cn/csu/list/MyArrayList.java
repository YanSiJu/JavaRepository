/**
 * 
 */
package cn.csu.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Bill
 *
 */
public class MyArrayList<E> extends ArrayList<E> implements List<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MyArrayList() {

	}

	/**
	 * @param initialCapacity
	 */
	public MyArrayList(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param c
	 */
	public MyArrayList(Collection<? extends E> c) {
		super(c);
	}

	public ArrayListIterator myIterator() {
		return new ArrayListIterator();
	}

	public class ArrayListIterator implements ListIterator<E> {

		private int cursor = MyArrayList.this.size() - 1;
		private int lastRet = -1;
		private int exceptedmodCount = modCount;

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// System.out.println("hasPrevious()!!" + " cursor--->" + (cursor == -1));
			return !(cursor == -1);
		}

		@Override
		public E next() {
			return null;
		}

		@Override
		public E previous() {
			// System.out.println("previous()!!");
			checkForComodification();
			int i = cursor;
			if (i < 0) {
				throw new NoSuchElementException();
			}
			cursor = i - 1;
			return MyArrayList.this.get(lastRet = i);
		}

		public void checkForComodification() {
			if (exceptedmodCount != modCount) {
				throw new ConcurrentModificationException();
			}
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			return cursor - 1;
		}

		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}

			MyArrayList.this.remove(lastRet);
			System.out.println("lastRet--->"+MyArrayList.this.get(lastRet));
//			cursor = lastRet; 
			lastRet = -1;
			exceptedmodCount = modCount;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub

		}

	}

}
