package cn.csu.arithmetic;

import cn.csu.datastructure.ListNode;

/**
 * @author Bill
 *
 */
public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode node = null;
		ListNode head = null;
		ListNode tail = null;
		int value = 0;
		int flag = 0;

		while (l1 != null && l2 != null) {
			value = l1.val + l2.val + flag;
			flag = 0;
			if (value > 9) {
				flag = 1;
				value -= 10;
			}

			if (head == null) {

				head = new ListNode(value);
				head.next = null;
				tail = head;
			} else {
				node = new ListNode(value);
				node.next = null;
				tail.next = node;
				tail = node;
			}
			l1 = l1.next;
			l2 = l2.next;
		}

		if (l1 != null) {
			while (l1 != null) {
				value = l1.val + flag;
				flag = 0;
				if (value > 9) {
					flag = 1;
					value -= 10;
				}

				node = new ListNode(value);
				node.next = null;
				tail.next = node;
				tail = node;

				l1 = l1.next;
			}

		} else if (l2 != null) {

			while (l2 != null) {
				value = l2.val + flag;
				flag = 0;
				if (value > 9) {
					flag = 1;
					value -= 10;
				}

				node = new ListNode(value);
				node.next = null;
				tail.next = node;
				tail = node;

				l2 = l2.next;
			}
		}
		if (flag == 1) {
			node = new ListNode(1);
			node.next = null;
			tail.next = node;
			tail = node;
		} /*
			 * int number = AddTwoNumbers.toInt(l1) + AddTwoNumbers.toInt(l2); return
			 * AddTwoNumbers.fetchNumbers(number);
			 */
		return head;

	}

	public static int length(ListNode list) {
		int n = 0;
		while (list != null) {
			list = list.next;
			n++;
		}
		return n;
	}

	public static int toInt(ListNode list) {

		int m = length(list);
		int j = 1;
		int number = 0;
		while (list != null) {
			number += (int) list.val * Math.pow(10, m - j);
			j++;
			list = list.next;
		}
		return number;

	}

	public static ListNode fetchNumbers(int number) {

		ListNode list = null;
		ListNode head = null;
		ListNode tail = null;

		head = new ListNode(number % 10);
		head.next = null;
		tail = head;
		number /= 10;

		while (number > 0) {

			list = new ListNode(number % 10);
			list.next = null;
			tail.next = list;
			tail = list;

			number = number / 10;
		}
		return head;

	}
}
