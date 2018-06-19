package cn.csu.arithmetic;

import cn.csu.datastructure.ListNode;

public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode next = null;
		ListNode prior = null;

		while (node != null) {
			next = node.next;
			if (node == head) {
				if (next != null) {
					node.next = next.next;
					next.next = node;
				}
				head = next;
			} else {
				if (next != null) {
					node.next = next.next;
					next.next = node;
				}

			}
			if (prior != null) {
				if (next == null) {
					prior.next = node;
				} else {
					prior.next = next;
				}

			}
			prior = node;
			node = node.next;
		}
		return head;

	}
}
