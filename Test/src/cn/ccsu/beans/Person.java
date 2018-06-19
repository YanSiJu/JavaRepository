package cn.ccsu.beans;

import java.io.Serializable;

public class Person implements Comparable<Person>,Cloneable,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6398447481726571267L;
	private String name;
	private Integer age;
	private String sex;
	private Integer id;
	private static short num = 0;
	
	/*public void Person(){
		
		System.out.println("Test Test  Test!!");
		
		
	}*/
	
	
	public Person() {

		System.out.println("Person 类的无参构造方法");

	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", ID=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	public Person(String name, Integer age, String sex, Integer id) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.id = id;
		System.out.println("带有4个参数的构造器");
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("带有2个参数的构造器:"+(++Person.num));
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub

		int i = this.id.compareTo(o.id);
		if (i == 0) {

			i = this.age.compareTo(o.age);
			if (i == 0) {
				i = this.name.compareTo(o.name);
				if (i == 0) {

					return this.sex.compareTo(o.sex);

				} else {
					return i;
				}
			} else {

				return i;
			}

		} else {

			return i;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
