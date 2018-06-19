package cn.csu.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sex;
	private int age;
	private Address address;

	@Override
	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;

	}

	public Object deepClone() throws IOException, ClassNotFoundException {

		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
		objectStream.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(byteStream.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);

		return ois.readObject();

	}

	public Student() {
		this.address = new Address();
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	public Student(String sex, int age, Address address) {
		super();
		this.sex = sex;
		this.age = age;
		this.address = address;
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
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
