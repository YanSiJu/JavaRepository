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
		list.add("ϰ��ƽ");
		list.add("���ǿ");
		list.add("��ս��");
		list.add("����");
		list.add("������");
		list.add("���ּ�");
		list.add("����");
		list.add("���ɽ");
		System.out.println(list);
		System.out.println(list.get(-2));
	}

}
