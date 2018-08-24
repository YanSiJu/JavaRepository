package cn.csu;

import java.io.Console;
import java.util.Arrays;

public class SysConsole {

	public static void main(String[] args) {
		Console cons = System.console();
		System.out.println(cons);
		char[] passwd = cons.readPassword("password:");
		System.out.println(Arrays.toString(passwd));
	}
}
