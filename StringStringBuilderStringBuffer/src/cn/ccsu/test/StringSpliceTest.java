package cn.ccsu.test;

import org.junit.Test;

public class StringSpliceTest {

	public StringSpliceTest() {

	}

	 @Test
	public void spliceTest() {
		String S2 = "This is only a";
		String S3 = "simple";
		String S4 = " test";
		@SuppressWarnings("unused")
		String S1 = S2 +S3 + S4;
	}

}
