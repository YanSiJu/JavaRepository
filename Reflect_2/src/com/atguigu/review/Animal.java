package com.atguigu.review;

public class Animal {
	private String name;
	public int age;
	static String desc = "����һ������";
	
	public Animal() {
		super();
		System.out.println("!!!");
	}

	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void info(){
		System.out.println("����");
	}
	
	public void show(String desc){
		System.out.println("����һ����" + desc);
	}
	
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getDesc() {
		return desc;
	}

	public static void setDesc(String desc) {
		Animal.desc = desc;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	
	
}
