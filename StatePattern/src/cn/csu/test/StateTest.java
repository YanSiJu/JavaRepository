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

			System.out.println("1.���  2.ȡ��  3.�˳�:");

			n = in.nextInt();
			if (n == 1) {
				acc.deposit();// ���
			} else if (n == 2) {
				acc.withdraw();// ȡ��
			} else if (n == 3) {
				break;
			} else {
				System.out.println("����������������������:");
			}

		}
		in.close();
		AbstractState.close();

	}

}
