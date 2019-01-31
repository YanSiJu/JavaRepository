package cn.csu.test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;
import org.junit.Test;

public class MapTest {

	@Test
	public void hashMapTest() {
		HashMap<Object, Object> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map);

		Hashtable<Object, Object> table = new Hashtable<>();
		table.put(LocalDateTime.now(), null);
		System.out.println(table);
	}
}
