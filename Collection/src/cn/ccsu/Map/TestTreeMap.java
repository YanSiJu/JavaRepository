package cn.ccsu.Map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import org.junit.Test;
import cn.ccsu.beans.Person;

public class TestTreeMap {

	@Test
	public void test() {

		Map<Person, Object> map = new TreeMap<>();

		map.put(new Person("Maven", 30, "Female", 96), 25);
		map.put(new Person("Mike", 28, "Male", 29), "m");
		map.put(new Person("Mike", 28, "male", 29), "f");
		map.put(new Person("Mike", 18, "Male", 29), 69);
		map.put(new Person("Mary", 28, "Male", 29), 69);

		Set<Entry<Person, Object>> set = map.entrySet();

		for (Entry<Person, Object> entry : set) {
			System.out.println(entry + "  ");
		}

	}

	@Test
	public void test1() {

		Comparator<Person> com = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				if (i == 0) {

					i = o1.getAge().compareTo(o2.getAge());
					if (i == 0) {
						i = o1.getName().compareTo(o2.getName());
						if (i == 0) {

							return o1.getSex().compareTo(o2.getSex());

						} else {
							return i;
						}
					} else {

						return i;
					}

				} else {

					return i;
				}

			}
		};
		
		Map<Person,Object> map = new TreeMap<>(com);
		
		System.out.println("\n  Comparator ");
		
		map.put(new Person("Maven", 30, "Female", 96), 25);
		map.put(new Person("Mike", 28, "Male", 29), "m");
		map.put(new Person("Mike", 28, "male", 29), "f");
		map.put(new Person("Mike", 18, "Male", 29), 69);
		map.put(new Person("Mary", 28, "Male", 29), 69);

		Set<Map.Entry<Person, Object>> set = map.entrySet();
		for (Entry<Person, Object> entry : set) {
			System.out.println(entry + "  ");
		}
		
		
	}
}
