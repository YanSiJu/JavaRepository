package cn.csu.practice.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import cn.csu.practice.Twentyfive;

public class TwentyfiveTest {

	@Test
	public void testIsPalindromicnumber() {
		fail("Not yet implemented");
		int n = 0;
		System.out.println(n + "是否为回文数?---->" + Twentyfive.isPalindromicnumber(n));
	}

	@Test
	public void testDigitNumber() {
		fail("Not yet implemented");
		List<Integer> numbers = new ArrayList<Integer>();
		int n = 0;
		Twentyfive.digitNumber(n, numbers);
		System.out.println(numbers);
	}

}
