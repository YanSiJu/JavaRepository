package cn.ccsu.test;

import cn.ccsu.beans.Student;

public class TestStudent {

	public static void main(String[] args) {

		Student s = new Student("Obama", "Male", "10256905");
		Student student = new Student("Bill", "Female", "10256905");

		System.out.println("      修改属性");
		System.out.println("修改前:" + s);
		TestStudent.test(s, "Jeff");
		System.out.println("修改后:" + s);

		System.out.println("\n      修改指向");
		
		/*Integer a = 20;
		System.out.println("修改前:" + a);
		TestStudent.modify(a, 900);
		System.out.println("修改后:" + a);
*/
		System.out.println("\n修改前:" + s);
		TestStudent.modify(s, student);
		System.out.println("修改后:" + s);

	}

	public static void test(Student s, String name) {

		s.setName(name);

	}

	public static <T> void modify(T a, T b) {

		a = b;
	}
}
