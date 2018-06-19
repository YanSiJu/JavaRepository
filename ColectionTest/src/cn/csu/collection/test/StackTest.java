package cn.csu.collection.test;

import cn.csu.collection.Stack;

public class StackTest {

	public StackTest() {

	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String s : "My dog has fleas".split(" "))
			stack.push(s);

		System.out.println("stack.peek():" + stack.peek());
		System.out.println("peekLast():" + stack.peekLast());

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

}
