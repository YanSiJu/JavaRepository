package cn.ccsu.beans;

public class Student {

	public Student() {
		
	}

	public Student(String name, String sex, String tel) {
		super();
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}

	private String name;
	private String sex;
	private String tel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", tel=" + tel + "]";
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
