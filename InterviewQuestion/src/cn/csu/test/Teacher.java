package cn.csu.test;

class Person {
	public Person() {

		System.out.println("this is a Person");
	}
}

public class Teacher extends Person {
	public Teacher() {
		System.out.println("this is a teacher");
		// super();
	}

	public static void main(String[] args) {
		new Teacher();
	}
}
