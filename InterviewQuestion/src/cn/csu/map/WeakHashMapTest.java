package cn.csu.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new WeakHashMap<>();
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
		System.out.println(map.size());
		System.out.println(map.size());
	}
}
