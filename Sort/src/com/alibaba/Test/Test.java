package com.alibaba.Test;

import com.alibaba.sort.SelectSort;

//import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
	//	fail("Not yet implemented");
		
		Integer a = new Integer(56);
		Integer b = new Integer(54);
		System.out.println("\nBefore:a:"+a.hashCode()+"  b:"+b.hashCode());
		
		SelectSort.swap(a,b);
		
		System.out.println("\nAfter:a:"+a+"  b:"+b);
		
	}

}
