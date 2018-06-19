package cn.ccsu.Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import java.util.Map.Entry;

import cn.ccsu.beans.Person;

public class TestLinkedHashMap {

	@Test
	public void test() {
		Map<Object, Object> map = new LinkedHashMap<>();

		map.put("Class", map.getClass());
		map.put("name", "JetBrains.");
		map.put("number", 328);
		map.put("Integer", 983);
		map.put("AA", "a");
		map.put("AA", "b");
		map.put(null, "kin");
		map.put(new Person("Junia", 23), "aaa");
		map.put(new Person("Junia", 23), "bbb");
		System.out.println("size:" + map.size());

		System.out.println("\n     LinkedHashMap  entrySet   ");
		Set<Entry<Object, Object>> set = map.entrySet();
		for (Entry<Object, Object> entry : set) {
			System.out.print(entry + "  ");
		}

	}

}
