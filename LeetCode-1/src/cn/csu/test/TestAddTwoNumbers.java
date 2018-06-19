package cn.csu.test;

import cn.csu.arithmetic.AddTwoNumbers;
import cn.csu.datastructure.ListNode;

/**
 * @author Bill
 *
 */
public class TestAddTwoNumbers {

	public static void main(String... args) {

		int[] a = {9,1,6};
		int[] b = {0};
		
		ListNode list = null;
		ListNode head = null;
		
		list = createList(list, a);
		head = createList(head, b);
		printList(AddTwoNumbers.addTwoNumbers(list, head));
		

	}

	public static ListNode createList(ListNode head, int[] a) {

		head = new ListNode(a[0]);
		head.next = null;
		ListNode tail = head;

		ListNode node = null;
		for (int i = 1; i < a.length; i++) {
			node = new ListNode(a[i]);
			node.next = null;
			tail.next = node;
			tail = node;
		}
		return head;
	}

	public static void printList(ListNode head) {
		ListNode list = head;
		System.out.print(" \nprintList \n");
		while (list != null) {
			System.out.print(list.val+"  ");
			list = list.next;
		}
	}
}
