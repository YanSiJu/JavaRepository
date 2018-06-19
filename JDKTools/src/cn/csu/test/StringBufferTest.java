package cn.csu.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBufferTest {

	@Test
	public void testToString() {
		// fail("Not yet implemented");
		StringBuffer s = new StringBuffer("Deepin");
		System.out.println(s);
		s.append("Linux");
		System.out.println(s);

	}

	@Test
	public void testLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testCharAt() {
		fail("Not yet implemented");
	}

	@Test
	public void testSubstringInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppendObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testAppendString() {
		fail("Not yet implemented");
		StringBuffer s = new StringBuffer("Deepin");
		String str = null;
		s.append(str);
		Object obj = null;
		s.append(obj);
		System.out.println(s);
	}

	@Test
	public void testAppendStringBuffer() {
		fail("Not yet implemented");
	}

}
