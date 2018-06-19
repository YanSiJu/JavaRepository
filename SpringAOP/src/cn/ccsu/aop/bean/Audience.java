package cn.ccsu.aop.bean;

public class Audience {

	public Audience() {
		System.out.println("constructor" + this.getClass().getName() + "\n");
	}

	public void silenceCellphone(String name) {
		System.out.println("silencing Cell phones.  name:" + name);
	}

	public void takeSeats(String name) {
		System.out.println("Taking Seats. name:" + name);
	}

	public void applause(String name) {
		System.out.println("\nclap clap clap!!  name:" + name);
	}

	public void refund(String name) {
		System.out.println("Demanding a refund!!  name:" + name);
	}

}
