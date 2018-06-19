package cn.csu.beans;



public class GeneralUser extends User {

	public GeneralUser(String name) {
		super();
	}

	public GeneralUser(String name, String pwd, int born, String type) {
		super(name, pwd, born, type);
	}

	@Override
	public void information() {
		System.out.println(super.getName() + " is " + super.getType() + ","
				+ super.getAge() + " years old.");

	}

}
