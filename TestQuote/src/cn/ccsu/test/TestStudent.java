package cn.ccsu.test;

import cn.ccsu.beans.Student;

public class TestStudent {

	public static void main(String[] args) {

		Student s = new Student("Obama", "Male", "10256905");
		Student student = new Student("Bill", "Female", "10256905");

		System.out.println("      �޸�����");
		System.out.println("�޸�ǰ:" + s);
		TestStudent.test(s, "Jeff");
		System.out.println("�޸ĺ�:" + s);

		System.out.println("\n      �޸�ָ��");
		
		/*Integer a = 20;
		System.out.println("�޸�ǰ:" + a);
		TestStudent.modify(a, 900);
		System.out.println("�޸ĺ�:" + a);
*/
		System.out.println("\n�޸�ǰ:" + s);
		TestStudent.modify(s, student);
		System.out.println("�޸ĺ�:" + s);

	}

	public static void test(Student s, String name) {

		s.setName(name);

	}

	public static <T> void modify(T a, T b) {

		a = b;
	}
}
