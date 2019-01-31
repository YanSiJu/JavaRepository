package cn.ccsu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

public class UdpChannel {

	@Test
	public void client() {
		DatagramChannel datagramChannel = null;
		Scanner scanner = null;
		try {
			// 获取通道
			datagramChannel = DatagramChannel.open();

			// 设置为非阻塞模式
			datagramChannel.configureBlocking(false);

			// 分配缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(1024);

			scanner = new Scanner(System.in);
			// 设置服务器地址
			SocketAddress target = new InetSocketAddress("127.0.0.1", 9898);
			while (scanner.hasNext()) {
				String info = scanner.next();
				String message = info + "  " + LocalDateTime.now();
				// 向缓冲区写入数据
				buffer.put(message.getBytes());
				// 切换为读模式
				buffer.flip();
				// 发送数据
				datagramChannel.send(buffer, target);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (datagramChannel != null) {
				try {
					datagramChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void server() {
		DatagramChannel datagramChannel = null;
		try {

			// 获取通道
			datagramChannel = DatagramChannel.open();
			// 配置为非阻塞模式
			datagramChannel.configureBlocking(false);
			// 绑定端口
			datagramChannel.bind(new InetSocketAddress(9898));

			// 获取选择器
			Selector selector = Selector.open();
			// 将通道注册到选择器上
			// datagramChannel.register(selector, SelectionKey.OP_ACCEPT); error
			datagramChannel.register(selector, SelectionKey.OP_READ);
			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey selectionKey = it.next();
					if (selectionKey.isReadable()) {
						ByteBuffer buffer = ByteBuffer.allocate(1024);
						// 从通道中读取数据
						// datagramChannel.read(buffer); error
						datagramChannel.receive(buffer);
						buffer.flip();
						System.out.println(new String(buffer.array(), 0, buffer.limit()));
						// 清空缓冲区
						buffer.clear();
					}
				}
				// 移除选择键
				it.remove();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (datagramChannel != null) {
				try {
					datagramChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
