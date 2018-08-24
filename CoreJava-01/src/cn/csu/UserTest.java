package cn.csu;

public class UserTest {

	public static void main(String[] args) {
		User user = User.getInstance();
		User u = User.getInstance();

		System.out.println("Before set:");
		System.out.println(u);
		System.out.println(user);

		System.out.println(u == user);
		System.out.println(u.equals(user));

		u.setName("Bill");

		System.out.println("After set:");
		System.out.println(u);
		System.out.println(user);

		System.out.println(u == user);
		System.out.println(u.equals(user));
	}
}
