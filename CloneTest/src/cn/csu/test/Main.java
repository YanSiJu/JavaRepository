package cn.csu.test;

import java.io.IOException;
import cn.csu.bean.Address;
import cn.csu.bean.Student;

public class Main {

	public static void main(String[] args) {

		Student s = new Student("Male", 20, new Address("Hongkong", "Street-1"));
		Student copyStudent = null;
		try {
			copyStudent = (Student) s.deepClone();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("copyStudent == s:" + (copyStudent == s));
		System.out
				.println("copyStudent.getAddress() == s.getAddress():" + (copyStudent.getAddress() == s.getAddress()));
		System.out.println("copyStudent.getSex() == s.getSex():" + (copyStudent.getSex() == s.getSex()));

	}

	public Main() {

		System.out.println("Main!!");
	}

}
