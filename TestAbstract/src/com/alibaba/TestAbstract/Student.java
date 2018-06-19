package com.alibaba.TestAbstract;

import org.junit.Test;

public class Student extends Person {

	@Override
	public void show() {
		// TODO Auto-generated method stub

		System.out.println(this.getName());
	}

	public Student() {

		System.out.println("Student's constructor 1");

	}
	
	@Test
	public void test(){
		
		Student s = new Student();
		System.out.println("$ "+s);
	}

	@Override
	public String toString() {
		return "Student [toString()=" + super.toString() + "]";
	}

}
