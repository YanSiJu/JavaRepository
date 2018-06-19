package com.alibaba.testStatic;

public class Person {

	private String name;
	private Short age;
	private static String nation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public static String getNation() {
		return nation;
	}

	public static void setNation(String nation) {
		Person.nation = nation;
	}

	public Person(String name, Short age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void show() {

		System.out.println("show method" + nation);

	}

	public static void display(){

		System.out.println(nation);
		info();
		//show();
		
	}

	
	public static void info(){
		
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
