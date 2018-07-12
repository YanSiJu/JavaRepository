package com.alibaba.junit;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class LocalDateTimeTest {

	@Test
	void timeStampTest() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		// 将localDateTime转换成时间戳
		System.out.println("localDateTime:" + localDateTime);
		System.out.println("timeStamp:" + java.sql.Timestamp.valueOf(localDateTime).getTime());
		// 使用System获取时间戳
		System.out.println("system:" + System.currentTimeMillis());
	}

}
