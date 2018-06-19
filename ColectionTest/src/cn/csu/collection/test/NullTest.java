package cn.csu.collection.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

public class NullTest {

	public NullTest() {

	}

	@Test
	public void listNullTest() {

		List<Integer> arr = new ArrayList<>();
		try {
			arr.add(null);
		} catch (Exception e) {
			System.out.println("ArrayList does not allow null");
		}

		List<Integer> list = new LinkedList<>();
		try {
			list.add(null);
		} catch (Exception e) {
			System.out.println("LinkedList does not allow null");
		}

		List<Integer> vector = new Vector<>();
		try {
			vector.add(null);
		} catch (Exception e) {
			System.out.println("Vector does not allow null");
		}
	}

	@Test
	public void mapNullTest() {
		Map<Integer, Integer> hashMap = new HashMap<>();
		try {
			hashMap.put(null, null);
		} catch (Exception e) {
			System.out.println("HashMap does not allow null");
		}

		Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
		try {
			linkedMap.put(null, null);
		} catch (Exception e) {
			System.out.println("LinkedHashMap does not allow null");
		}

		Map<Integer, Integer> treeMap = new TreeMap<>();
		try {
			treeMap.put(null, 3);
		} catch (Exception e) {
			System.out.println("TreeMap does not allow null");
		}

	}
	
	
	
	@Test
	public void setNullTest() {
		Set<Integer> hashSet = new HashSet<>();
		try {
			hashSet.add(null);
		} catch (Exception e) {
			System.out.println("HashSet does not allow null");
		}

		Set<Integer> linkedSet = new LinkedHashSet<>();
		try {
			linkedSet.add(null);
		} catch (Exception e) {
			System.out.println("LinkedHashSet does not allow null");
		}

		Set<Integer> treeSet = new TreeSet<>();
		try {
			treeSet.add(null);
		} catch (Exception e) {
			System.out.println("TreeSet does not allow null");
		}

	}

}
