package com.alibaba.string;

//import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

	@Test
	public void test() {
		
//		fail("Not yet implemented");
		String str = "Java";
		System.out.println(str.intern() == "Java".intern());
		
		
		
		char[] c = str.toCharArray();
		System.out.println(c);
		
		
		
		
		System.out.println("\nbyte");
		byte[] b  = str.getBytes();
		for(byte by:b)
			System.out.print((char)by);
		
		
		
		int a = 320;
		Integer b1 = 34;
		
		@SuppressWarnings("unused")
		String string = String.valueOf(a);
		string = String.valueOf(b1);
	}

}
