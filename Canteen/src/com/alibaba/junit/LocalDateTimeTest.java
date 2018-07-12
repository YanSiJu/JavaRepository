package com.alibaba.junit;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class LocalDateTimeTest {

	@Test
	void timeStampTest() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		// ��localDateTimeת����ʱ���
		System.out.println("localDateTime:" + localDateTime);
		System.out.println("timeStamp:" + java.sql.Timestamp.valueOf(localDateTime).getTime());
		// ʹ��System��ȡʱ���
		System.out.println("system:" + System.currentTimeMillis());
	}

}
