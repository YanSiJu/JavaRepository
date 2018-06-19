package cn.ccsu.Set;

import java.util.HashSet;
import java.util.Set;

import cn.ccsu.beans.Person;

public class TestHashSet {

	public static void main(String[] args) {

		Set<Person> set = new HashSet<>();
		

		Person p = new Person("Mikeal", 25);
		Person person = new Person("Mikeal", 29);
		Person m = new Person("Mary", 27);
		Person n = new Person("Martin", 28);
		Person a = new Person("Mary", 25);

		
		set.add(m);
		set.add(p);
		set.add(a);
		set.add(n);
		
		
//		set.add(person);

		System.out.println(set);

		System.out.println("p:" + p.hashCode() + "   person:" + person.hashCode());
		System.out.println("n:"+n.hashCode());
		if (p != null) {
			System.out.println(p.equals(person));
		}

	}
}
