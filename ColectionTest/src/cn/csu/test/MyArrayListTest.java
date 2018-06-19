package cn.csu.test;

import java.util.ListIterator;
import cn.csu.list.MyArrayList;

public class MyArrayListTest {

	public MyArrayListTest() {
	}

	public static void main(String[] args) {
		// List<Integer> list=new MyArrayList<>(Arrays.asList(23,12,54,32,54));
		// Collections.addAll(list,23,12,54,32,54);

		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(23);
		list.add(12);
		list.add(54);
		list.add(35);
		list.add(64);
		list.add(90);
		list.add(52);
		list.add(72);

		System.out.println("before removing,size:" + list.size());
		ListIterator<Integer> it = list.myIterator();
		while (it.hasPrevious()) {
			if (it.previous() == 35) {
				it.remove();
			}
		}

		System.out.println("after removing,size:" + list.size());
		ListIterator<Integer> it2 = list.myIterator();
		while (it2.hasPrevious()) {
			int n = it2.previous();
			System.out.print(n + "  ");
		}
	}

}
