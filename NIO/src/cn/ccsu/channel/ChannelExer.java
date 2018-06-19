package cn.ccsu.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class ChannelExer {

	@Test
	public void nonDirectBufferTest() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;

		try {
			long start = System.currentTimeMillis();
			fis = new FileInputStream("D:\\Eclipse_Workspace\\NIO\\src\\Java8 API.chm");
			fos = new FileOutputStream("D:\\Eclipse_Workspace\\NIO\\src\\1.chm");
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			ByteBuffer buff = ByteBuffer.allocate(1024);
			while ((inChannel.read(buff)) != -1) {
				buff.flip();
				outChannel.write(buff);
				buff.clear();
			}
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void mappedBufferTest() {

		FileChannel inChannel = null;
		FileChannel outChannel = null;

		try {
			long start = System.currentTimeMillis();
			inChannel = FileChannel.open(
					Paths.get("D:\\Eclipse_Workspace\\NIO\\src\\Java8 API.chm"),
					StandardOpenOption.READ);
			outChannel = FileChannel.open(
					Paths.get("D:\\Eclipse_Workspace\\NIO\\src\\2.chm"),
					StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			MappedByteBuffer inBuffer = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
			MappedByteBuffer outBuffer = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			byte[] b = new byte[inBuffer.limit()];
			inBuffer.get(b);
			outBuffer.put(b);
			outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inChannel != null) {
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (outChannel != null) {
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
