package com.alibaba.TestAbstract;

public abstract class Person {

	
	private String name;

	public Person() {
		System.out.println("Person's constructor 1");
	}

	public Person(String name) {
		this.setName(name);
		System.out.println("Person's constructor  2");

	}

	public abstract void show();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}