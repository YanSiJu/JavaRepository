package com.atguigu.nio;

import java.nio.ByteBuffer;

import org.junit.Test;

/*
 * һ����������Buffer������ Java NIO �и������ݵĴ�ȡ���������������顣���ڴ洢��ͬ�������͵�����
 * 
 * �����������Ͳ�ͬ��boolean ���⣩���ṩ����Ӧ���͵Ļ�������
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 
 * �����������Ĺ���ʽ����һ�£�ͨ�� allocate() ��ȡ������
 * 
 * ������������ȡ���ݵ��������ķ�����
 * put() : �������ݵ���������
 * get() : ��ȡ�������е�����
 * 
 * �����������е��ĸ��������ԣ�
 * capacity : ��������ʾ�����������洢���ݵ�������һ���������ܸı䡣
 * limit : ���ޣ���ʾ�������п��Բ������ݵĴ�С����limit �����ݲ��ܽ��ж�д��
 * position : λ�ã���ʾ�����������ڲ������ݵ�λ�á�
 * 
 * mark : ��ǣ���ʾ��¼��ǰ position ��λ�á�����ͨ�� reset() �ָ��� mark ��λ��
 * 
 * 0 <= mark <= position <= limit <= capacity
 * 
 * �ġ�ֱ�ӻ��������ֱ�ӻ�������
 * ��ֱ�ӻ�������ͨ�� allocate() �������仺�������������������� JVM ���ڴ���
 * ֱ�ӻ�������ͨ�� allocateDirect() ��������ֱ�ӻ��������������������������ڴ��С��������Ч��
 */
public class TestBuffer {

	@Test
	public void test3() {
		// ����ֱ�ӻ�����
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);

		System.out.println(buf.isDirect());
	}

	@Test
	public void test2() {
		String str = "abcde";

		ByteBuffer buf = ByteBuffer.allocate(1024);

		buf.put(str.getBytes());

		buf.flip();// 0 5 1024

		byte[] dst = new byte[buf.limit()];
		buf.get(dst, 0, 2);// 2 5 1024
		System.out.println(new String(dst, 0, 2));
		System.out.println(buf.position());// 2

		// mark() : ���
		buf.mark();// 2

		buf.get(dst, 2, 2);// 4 5 1024
		System.out.println(new String(dst, 2, 2));// cd
		System.out.println(buf.position());// 4

		// reset() : �ָ��� mark ��λ��
		buf.reset();// 2 5 1024
		System.out.println(buf.position());// 2

		// �жϻ��������Ƿ���ʣ������
		if (buf.hasRemaining()) {
			// ��ȡ�������п��Բ���������
			System.out.println(buf.remaining());// 3
		}
	}

	@Test
	public void test1() {
		String str = "abcde";

		// 1. ����һ��ָ����С�Ļ�����
		ByteBuffer buf = ByteBuffer.allocate(1024);

		System.out.println(buf);
		System.out.println("-----------------allocate()----------------");
		System.out.println(buf.position());// 0
		System.out.println(buf.limit());// 1024
		System.out.println(buf.capacity());// 1024

		// 2. ���� put() �����ݵ���������
		buf.put(str.getBytes());

		System.out.println("-----------------put()----------------");
		System.out.println(buf);
		System.out.println(buf.position());// 5
		System.out.println(buf.limit());// 1024
		System.out.println(buf.capacity());// 1024

		// 3. �л���ȡ����ģʽ
		buf.flip();

		System.out.println("-----------------flip()----------------");
		System.out.println(buf.position());// 0
		System.out.println(buf.limit());// 5
		System.out.println(buf.capacity());// 1024

		// 4. ���� get() ��ȡ�������е�����
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println(new String(dst, 0, dst.length));

		System.out.println("-----------------get()----------------");
		System.out.println(buf.position());// 5
		System.out.println(buf.limit());// 5
		System.out.println(buf.capacity());// 1024

		// 5. rewind() : ���ظ���
		buf.rewind();

		System.out.println("-----------------rewind()----------------");
		System.out.println(buf.position());// 0
		System.out.println(buf.limit());// 5
		System.out.println(buf.capacity());// 1024

		// 6. clear() : ��ջ�����. ���ǻ������е�������Ȼ���ڣ����Ǵ��ڡ���������״̬
		buf.clear();

		System.out.println("-----------------clear()----------------");
		System.out.println(buf.position());// 0
		System.out.println(buf.limit());// 1024
		System.out.println(buf.capacity());// 1024

		System.out.println((char) buf.get());// a

	}

}
