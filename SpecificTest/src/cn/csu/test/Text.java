package cn.csu.test;

import java.util.LinkedList;
import java.util.List;

public class Text {
	public static void main(String[] args) {
		 var list = new LinkedList<String>();
//		LinkedList<String> list = new LinkedList<String>();
		List.copyOf(list);
		list.addFirst("123");
		list.addFirst("1454");
		list.addFirst("1342");
		list.addFirst("134");
		list.addFirst("123423");
		list.addFirst("343");
		System.out.println(list);
	}
}