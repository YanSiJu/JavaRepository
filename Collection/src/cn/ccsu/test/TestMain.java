package cn.ccsu.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestMain {
	private static int SIZE = 111111;

	private static void loopList(List<Integer> arrayList) {

		long startTime = System.currentTimeMillis();
		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i);
		}
		System.out.println(arrayList.getClass().getSimpleName() + "使用普通for循环遍历时间为"
				+ (System.currentTimeMillis() - startTime) + "ms");

		startTime = System.currentTimeMillis();
		for (@SuppressWarnings("unused")
		Integer i : arrayList) {

		}
		System.out.println(arrayList.getClass().getSimpleName() + "使用foreach循环遍历时间为"
				+ (System.currentTimeMillis() - startTime) + "ms");

	}

	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>(SIZE);
		List<Integer> linkedList = new LinkedList<>();

		for (int i = 0; i < SIZE; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}

		display();
		loopList(arrayList);
		loopList(linkedList);
		System.out.println();
	}
	
	public static void fun(){
		
		display();
	}
	
	public static void display(){}
}
