package cn.csu.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<String, Object> map = new LinkedHashMap<String, Object>(16, 0.75F, true);

		for (int i = 1; i <= 5; i++) {
			map.put(i + "", i);
		}
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getValue());
		}

		map.get("2");
		map.get("3");
		System.out.println("===============split line==================");

		Iterator<Entry<String, Object>> iterator2 = map.entrySet().iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next().getValue());
		}
	}
}
