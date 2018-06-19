package cn.csu.beans;

public class VIPUser extends User {

	public VIPUser(String name) {
		super();
	}

	public VIPUser(String name, String pwd, int born, String type) {
		super(name, pwd, born, type);
	}

	

	@Override
	public void information() {
		System.out.println(super.getName() + " is " + super.getType() + ","
				+ super.getAge() + " years old.");

	}

}
