package cn.ccsu.entity;

public class Animal {

	public  Animal() {
		System.out.println(this.getClass() + "'s 无参构造器");

	}

	private String name;
	private String color;
	private int age;
	public static String description = "I'm an animal";

	@SuppressWarnings("unused")
	private void info() {
		System.out.println("I'm a " + age + " years old " + name);
	}

	public void dest(String country) {
		System.out.println("I'm from" + country);
	}

	public Animal(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [name=" + name + ", color=" + color + ", age=" + age + "]";
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		System.out.println("setColor");
		this.color = color;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		System.out.println("setAge(int)");
		this.age = age;
	}

}
