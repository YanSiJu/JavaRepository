package cn.csu.string;

public class DeleteCharacter {

	/**
	 * @author Bill
	 * @since JDK 1.8
	 * @param str
	 * @param character
	 * @return String 输入:一个字符串str和一个字符character 输出:一个删除了character字符的新字符串
	 * */
	public static String delete(String str, char character) throws Exception {

		StringBuilder newStr = new StringBuilder("");
		if (str == null) {

			new Exception("参数不能为空");
		}

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) != character) {
				newStr.append(str.charAt(i));
			}

		}

		return newStr.toString();
	}
}
