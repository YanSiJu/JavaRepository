package cn.csu.entity;

public class User {

	public User() {
		System.out.println("-----------------无参构造器-----------------");
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + "]";
	}

	private String userName;
	private int age;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
