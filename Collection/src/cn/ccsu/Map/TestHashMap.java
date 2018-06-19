package cn.ccsu.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import cn.ccsu.beans.Person;

public class TestHashMap {

	@Test
	public void testHashMap() {

		Map<Object, Object> map = new HashMap<>();
		
		
		map.put("number", 328);
		map.put("Integer", 983);
		map.put("AA", "a");
		map.put("AA", "b");
		map.put(null, "kin");
		map.put(new Person("Junia", 23), "aaa");
		map.put(new Person("Junia", 23), "bbb");
		map.put("Class", map.getClass());
		System.out.println("size:" + map.size());

		// long start = System.currentTimeMillis();

		Set<Entry<Object, Object>> set = map.entrySet();

		for (Entry<Object, Object> entry : set) {
			System.out.print(entry + "  ");
		}

		/*
		 * System.out.println("start:"+start); long end =
		 * System.currentTimeMillis();
		 * 
		 * System.out.println("\n start:"+start+"  end:"+end+"  "+(end -
		 * start));
		 */
	}
}
