package cn.csu.test;

import cn.csu.arithmetic.RomanToInteger;
import org.junit.Test;

public class RomantoIntegerTest {

	@Test
	public void testRomanToInt() {
		// fail("Not yet implemented");
		System.out.println(RomanToInteger.romanToInt("MCMXCIV"));
		System.out.println(RomanToInteger.romanToInt("III"));
		System.out.println(RomanToInteger.romanToInt("IX"));
		System.out.println(RomanToInteger.romanToInt("LVIII"));
		System.out.println(RomanToInteger.romanToInt("IV"));

	}

}
