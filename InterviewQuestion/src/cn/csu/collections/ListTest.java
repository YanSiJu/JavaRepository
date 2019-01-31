package cn.csu.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	public static void main(String[] args) {
		System.out.println(2 + 1 + "aaa" + 3 + 1);
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.listIterator();
		list.iterator();
		// list.add(2, "B");
		// String s = (String) list.get(1);
		// System.out.println(s);
	}

	@Test
	public void indexCheck() {
		List<String> list = new ArrayList<String>();
		list.add("习近平");
		list.add("李克强");
		list.add("栗战书");
		list.add("汪洋");
		list.add("王沪宁");
		list.add("赵乐际");
		list.add("韩正");
		list.add("王岐山");
		System.out.println(list);
		System.out.println(list.get(-2));
	}

}
