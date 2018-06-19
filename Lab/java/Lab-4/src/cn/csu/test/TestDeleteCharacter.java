package cn.csu.test;

import cn.csu.string.DeleteCharacter;

public class TestDeleteCharacter {

	public static void main(String[] args) throws Exception {

		String str = "java Linus C++ C#  Ca  javascript  s";
		char character = 's';
		System.out.println("原来的长度:" + str.length());
		String newStr = DeleteCharacter.delete(str, character).toString();
		System.out.println(newStr);
		System.out.println("现在的长度:" + newStr.length());
	}
}
