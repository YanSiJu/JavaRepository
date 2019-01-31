package cn.csu.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapExer {

	public static void main(String[] args) {
		int initialCapacity = 20;
		float loadFactor = 0.75f;
		boolean accessOrder = true;
		HashMap<Integer, String> map = new LinkedHashMap<Integer, String>(initialCapacity, loadFactor, accessOrder);

		map.put(1, "first");
		map.put(2, "second");
		map.put(3, "third");
		map.put(4, "fourth");
		map.put(5, "fifth");

		map.get(1);
		map.get(2);

		map.put(6, "sixth");
		map.put(7, "seven");
		System.out.println(map);
		map.remove(12);

	}

}
