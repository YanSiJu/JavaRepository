package cn.csu.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class IntervalTimeTest {

	public static void main(String[] args) {

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime time = LocalDateTime.of(2018, 01, 01, 00, 00, 00);
		System.out.println("now:" + now);
		System.out.println("time:" + time);
		System.out.println("It still have " + ChronoUnit.SECONDS.between(now, time) + " seconds left.");
	}
}
