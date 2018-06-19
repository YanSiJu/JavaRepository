package cn.ccsu.beans;

public class Student {

	
	private String name;
	private String sno;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Constructor!!");
		
		
	}
	private String sex;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("Set name");
	}
	
	public String getSno() {
		return sno;
	}
	
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSex() {
		return sex;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sno=" + sno + ", sex=" + sex + ", age=" + age + "]";
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
