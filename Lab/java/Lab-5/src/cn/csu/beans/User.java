package cn.csu.beans;

import java.util.Calendar;

import cn.csu.service.Userable;

public abstract class User implements Userable {

	public User(){
		
		
	}
	public User(String name) {
		super();
		this.name = name;
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User(String name, String pwd, int born, String type) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.born = born;
		this.type = type;
		this.age = Calendar.getInstance().get(Calendar.YEAR) - born;
	}

	public User(String name, String pwd, int born) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.born = born;
		this.age = Calendar.getInstance().get(Calendar.YEAR) - born;
	}

	private String name;
	private String pwd;
	private int age;
	private int born;
	private String type;
	
	/*{

		this.age = Calendar.getInstance().get(Calendar.YEAR) - this.born;
	}
*/
	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getBorn() {
		return born;
	}

	public void setBorn(int born) {
		this.born = born;
		this.age = Calendar.getInstance().get(Calendar.YEAR) - born;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public abstract void information();
}
