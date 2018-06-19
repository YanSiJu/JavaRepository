package main.java.com.waylau.netty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 测试用的 TCP 客户端
 * 
 * @author waylau.com
 * @date 2015-2-26
 */
public class TcpClient {

	public static void main(String[] args) {
		Socket socket = null;
		OutputStream out = null;

		try {

			socket = new Socket("localhost", 80);
			out = socket.getOutputStream();

			// 请求服务器
			String lines = "床前明月光\r\n疑是地上霜\r\n举头望明月\r\n低头思故乡\r\n";
			byte[] outputBytes = lines.getBytes("UTF-8");
			out.write(outputBytes);
			out.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
