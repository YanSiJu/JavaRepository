package cn.ccsu.channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class FileChannelExer {

	@Test
	public void fileChannel() {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		// 1.获取通道
		try {
			inChannel = FileChannel.open(Paths.get("src\\syria.png"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("src\\syria-2.png"), StandardOpenOption.READ,
					StandardOpenOption.WRITE, StandardOpenOption.CREATE);

			// 2.分配缓冲区
			ByteBuffer buff = ByteBuffer.allocate(1024);
			// 3.从inChannel中读取数据
			while (inChannel.read(buff) != -1) {
				// 切换到读数据模式
				buff.flip();
				// 将数据写到outChannel
				while (buff.hasRemaining()) {
					outChannel.write(buff);
				}
				// 清空缓冲区
				buff.clear();
			}
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

	@Test
	public void MemoryMappedfile() {
		FileChannel inChannel = null;
		FileChannel outChannel = null;

		try {
			inChannel = FileChannel.open(Paths.get("src\\syria.png"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("src\\syria-4.png"), StandardOpenOption.READ,
					StandardOpenOption.WRITE, StandardOpenOption.CREATE);
			long size = inChannel.size();
			MappedByteBuffer inMappedBuffer = inChannel.map(MapMode.READ_ONLY, 0, size);
			MappedByteBuffer outMappedBuffer = outChannel.map(MapMode.READ_WRITE, 0, size);

			byte[] buff = new byte[inMappedBuffer.limit()];
			inMappedBuffer.get(buff);
			outMappedBuffer.put(buff);
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

	@Test
	public void scatterReadAndGatherWrite() {
		FileChannel inChannel = null;
		FileChannel outChannel = null;

		try {
			inChannel = FileChannel.open(Paths.get("src\\syria.png"), StandardOpenOption.READ);
			outChannel = FileChannel.open(Paths.get("src\\syria-8.png"), StandardOpenOption.READ,
					StandardOpenOption.WRITE, StandardOpenOption.CREATE);

			ByteBuffer buffer = ByteBuffer.allocate(2048);
			ByteBuffer buff = ByteBuffer.allocate(1024);
			ByteBuffer[] buffs = { buff, buffer };

			// 分散读取到多个缓冲区中
			inChannel.read(buffs);
			// 将缓冲区切换为读状态
			for (ByteBuffer buf : buffs) {
				buf.flip();
			}
			// 将多个缓冲区的数据聚集写入到一个通道中
			outChannel.write(buffs);

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
