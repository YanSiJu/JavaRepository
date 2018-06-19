package cn.csu;

public class AssertTest {

	public AssertTest() {

	}

	public static void main(String[] args) {
//		String name = "abner chai";
		 String name = null;
		assert (name != null) : "nameΪnull";
		System.out.println(name);
	}

}
