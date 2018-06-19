package cn.csu.test;

import org.junit.Test;

import cn.csu.arithmetic.SwapNodesInPairs;
import cn.csu.datastructure.ListNode;

public class SwapNodesInPairsTest {

	@Test
	public void testSwapPairs() {
		// fail("Not yet implemented");
		ListNode head = new ListNode(1);
		ListNode node = null;
		node = head;
		for (int i = 0; i < 2; i++) {
			node.next = new ListNode(i + 2);
			node = node.next;
		}
		node = head;
		

		head = SwapNodesInPairs.swapPairs(head);
		node = head;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}

}
