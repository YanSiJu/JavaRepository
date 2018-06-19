package com.qzdatasoft.err;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Void aVoid;

		String[] a = new String[10];
		
		@SuppressWarnings("unused")
		String[] b = a.clone();
		System.err.println("\n7");

		System.out.println("\n1");
		System.out.println("\n2");
		System.out.println("\n3");

		System.err.println("\n6");
		System.err.println("\n4");
//
	}
}
