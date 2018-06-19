package cn.ccsu.buffer;

import java.nio.ByteBuffer;

import org.junit.Test;

public class ByteBufferExer {

	@Test
	public void exer() {

		String str = "Java";
		ByteBuffer buff = ByteBuffer.allocate(1024);

		System.out.println("------allocate()---------------------\n");
		System.out.println("position:" + buff.position());
		System.out.println("limit:" + buff.limit());
		System.out.println("capacity:" + buff.capacity());

		buff.put(str.getBytes());

		System.out.println("------put()---------------------\n");
		System.out.println("position:" + buff.position());
		System.out.println("limit:" + buff.limit());
		System.out.println("capacity:" + buff.capacity());

		buff.flip();
		System.out.println("get:" + (char)buff.get());

		System.out.println("------get()---------------------\n");
		System.out.println("position:" + buff.position());
		System.out.println("limit:" + buff.limit());
		System.out.println("capacity:" + buff.capacity());

		buff.compact();

		System.out.println("------compact()---------------------\n");
		System.out.println("position:" + buff.position());
		System.out.println("limit:" + buff.limit());
		System.out.println("capacity:" + buff.capacity());

		System.out.println("get:" + (char)buff.get());
		System.out.println("\nremaining():" + buff.remaining());
	}
}
