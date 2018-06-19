package cn.csu.test;

import java.util.Scanner;

import org.junit.Test;

import cn.csu.entity.Account;
import cn.csu.state.AbstractState;

public class StateTest {

	public StateTest() {

	}

	@Test
	public void test() {

		Account acc = new Account();

		int n = 0;
		Scanner in = new Scanner(System.in);
		while (true) {

			System.out.println("1.存款  2.取款  3.退出:");

			n = in.nextInt();
			if (n == 1) {
				acc.deposit();// 存款
			} else if (n == 2) {
				acc.withdraw();// 取款
			} else if (n == 3) {
				break;
			} else {
				System.out.println("您的输入有误，请重新输入:");
			}

		}
		in.close();
		AbstractState.close();

	}

}
