package cn.ccsu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

public class TcpChannel {

	@Test
	public void client() {
		SocketChannel sChannel = null;
		Scanner scan = null;
		try {
			// 获取通道
			sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
			// 切换为非阻塞模式
			sChannel.configureBlocking(false);
			// 分配指定大小(1024 byte)的缓冲区
			ByteBuffer buff = ByteBuffer.allocate(1024);
			scan = new Scanner(System.in);
			while (scan.hasNext()) {
				String message = scan.next();
				String info = message + "  " + LocalDateTime.now();
				buff.clear();
				// 将数据写入缓冲区
				buff.put(info.getBytes());
				// 切换为读模式
				buff.flip();
				// 发送缓冲区中的数据
				sChannel.write(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sChannel != null) {
				try {
					sChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (scan != null) {
				scan.close();
			}
		}
	}

	@Test
	public void server() {
		ServerSocketChannel sschannel = null;
		try {
			// 1.获取通道
			sschannel = ServerSocketChannel.open();
			// 2.切换为非阻塞模式
			sschannel.configureBlocking(false);
			// 3.绑定端口号
			sschannel.bind(new InetSocketAddress(9898));

			// 4.获取选择器
			Selector selector = Selector.open();
			// 5.将通道注册到选择器上，并监听“接受就绪”事件
			sschannel.register(selector, SelectionKey.OP_ACCEPT);
			// 6.轮询地获取通道上的“接收就绪”事件
			while (selector.select() > 0) {
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while (it.hasNext()) {
					SelectionKey selectionKey = it.next();
					// 处理“接收就绪”事件
					if (selectionKey.isAcceptable()) {
						// 接收客户端连接
						SocketChannel schannel = sschannel.accept();
						schannel.configureBlocking(false);
						// 将“接收就绪”的通道注册到选择器上,并监听其“读事件”
						schannel.register(selector, SelectionKey.OP_READ);
						// 处理“读就绪”事件
					} else if (selectionKey.isReadable()) {
						// 获取客户端连接通道
						// SocketChannel schannel = sschannel.accept();error
						SocketChannel schannel = (SocketChannel) selectionKey.channel();
						ByteBuffer buff = ByteBuffer.allocate(1024);
						int len = 0;
						// 从通道中读取数据
						while ((len = schannel.read(buff)) > 0) {
							buff.flip();
							System.out.println(new String(buff.array(), 0, len));
							buff.clear();
						}
					}
				}
				// 移除选择键
				it.remove();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭通道
			if (sschannel != null) {
				try {
					sschannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
