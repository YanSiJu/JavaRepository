package com.alibaba.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * HTTP Response = Status-Line *(( general-header | response-header |
 * entity-header ) CRLF) CRLF [message-body] Status-Line=Http-Version SP
 * Status-Code SP Reason-Phrase CRLF
 *
 */
public class Response {
	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public void sendFile(File file) {
		try {
			PrintStream printStream = new PrintStream(output);
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int len = (int) file.length();
			byte buf[] = new byte[len];
			in.readFully(buf);// 读取文内容到buf数组中
			printStream.write(buf, 0, len);
			printStream.flush();
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public void sendStaticResource() throws IOException {
		@SuppressWarnings("unused")
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			System.out.println("\n\n\n\n" + request.getUri() + "  " + HttpServer.WEB_ROOT);
			File file = new File(HttpServer.WEB_ROOT, request.getUri());
			if (file.exists()) {
				// fis = new FileInputStream(file);
				// int ch = fis.read(bytes, 0, BUFFER_SIZE);
				// while (ch != -1) {
				// output.write(bytes, 0, BUFFER_SIZE);
				// ch = fis.read(bytes, 0, BUFFER_SIZE);
				// }
				sendFile(file);
			} else {
				// file not found
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type:text/html\r\n"
						+ "Content-Length:23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
				output.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}