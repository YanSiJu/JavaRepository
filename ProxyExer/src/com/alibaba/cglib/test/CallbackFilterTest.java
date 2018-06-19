package com.alibaba.cglib.test;

import org.junit.Test;
import com.alibaba.cglib.Interceptor;
import com.alibaba.service.ICountService;
import com.alibaba.service.Impl.CountServiceImpl;

public class CallbackFilterTest {

	public CallbackFilterTest() {

	}

	@Test
	public void CallbackFilterTest_1() {
		ICountService service = (ICountService)new Interceptor().getProxyInstance(new CountServiceImpl());
		
		service.queryCount();
		service.deposit();
		service.updateCount();
		
		
	}

}
