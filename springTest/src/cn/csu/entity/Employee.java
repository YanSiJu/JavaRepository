package cn.csu.entity;

public class Employee {

	private String department;
	private double salary;
	private String name;
	
	
	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [department=" + department + ", salary=" + salary + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + "]";
	}

	private short age;
	private String sex;

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public short getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(short age) {
		this.age = age;
	}

	public Employee(String department, double salary, String name, String sex, short age) {
		super();
		this.department = department;
		this.salary = salary;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public Employee() {

	}

}
