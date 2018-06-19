package cn.ccsu.simpleFactory;

public class OperationFactory {

	public static Operation factoryMethod(String str) throws Exception {
		// return null;

		if ("Add".equalsIgnoreCase(str)) {
			return new Add();
		} else if ("Sub".equalsIgnoreCase(str)) {
			return new Sub();

		} else if ("Div".equalsIgnoreCase(str)) {

			return new Div();
		} else if ("Multi".equalsIgnoreCase(str)) {

			return new Multi();
		} else {
			throw new Exception("ÄúµÄÊäÈëÓĞÎó£¡£¡");
		}

	}

}
