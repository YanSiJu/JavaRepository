package cn.ccsu.lambda;

import java.util.function.Consumer;

public class MethodQuote {

	public static void main(String[] args) {

		Consumer<String> consumer = System.out::println;
		consumer.accept("Hello world!!");
	}
}
