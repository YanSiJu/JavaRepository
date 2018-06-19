package cn.csu.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	
	
	public static void main(String[] str) {
		Pattern pattern = Pattern.compile("[0-9]*");

		Matcher isNum = pattern.matcher(new Scanner(System.in).nextLine());
		if (!isNum.matches()) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}

	}
}