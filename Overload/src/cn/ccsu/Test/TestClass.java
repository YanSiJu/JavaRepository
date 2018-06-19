package cn.ccsu.Test;

class SuperClass {

	public static void staticMethod() {
		System.out.println("SuperClass: inside staticMethod");
	}

}

public class TestClass extends SuperClass {
	// overriding the static method
//	@Override
	public static void staticMethod() {
		System.out.println("SubClass: inside staticMethod");
	}

	public static void main(String[] args) {
		/*SuperClass superClassWithSuperCons = new SuperClass();
		SuperClass superClassWithSubCons = new TestClass();
		TestClass subClassWithSubCons = new TestClass();*/

//		superClassWithSuperCons.staticMethod();
//		superClassWithSubCons.staticMethod();
//		subClassWithSubCons.staticMethod();

	}

}