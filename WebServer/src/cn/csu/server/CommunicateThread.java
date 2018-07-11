package cn.csu.server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.Socket;

//ÿ��һ�����ӽ���ʱ���������ֳ�һ��ͨ�ŵ��߳�
public class CommunicateThread extends Thread {
	// ��ͻ���ͨ�ŵ��׽���
	Socket client;
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "WebContent";

	public CommunicateThread(Socket s) {
		client = s;
	}

	// ��ȡ�����������Դ��·��
	public String getResourcePath(String s) {
		// һ���HTTP�����ĵĵ�һ���ǡ�GET /index.html HTTP/1.1��
		// ����Ҫ��ȡ�ľ����м��"/indext.apsx"

		// ��ȡ��Դ��λ��
		String s1 = s.substring(s.indexOf(' ') + 1);
		s1 = s1.substring(1, s1.indexOf(' '));

		// Ĭ����ԴΪindex.html
		if (s1.equals(""))
			s1 = "index.html";

		return s1;
	}

	public void sendFile(PrintStream out, File file) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(file));
			int len = (int) file.length();
			byte buf[] = new byte[len];
			in.readFully(buf);// ��ȡ�����ݵ�buf������
			out.write(buf, 0, len);
			out.flush();
			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void run() {
		try {
			// ��ȡ�û���IP��ַ�Ͷ˿ں�
			String clientIP = client.getInetAddress().toString();
			int clientPort = client.getPort();
			// �������������
			PrintStream out = new PrintStream(client.getOutputStream());
			// ��������������
			DataInputStream in = new DataInputStream(client.getInputStream());
			// ��ȡ������ύ������
			String msg = in.readLine();
			System.out.print("\n\\n\n\nmsg:" + msg + "\n\n\n");
			// ��ȡ�ļ�·��
			String fileName = getResourcePath(msg);
			// System.out.println("\n\n\nThe user asked for resource: " + fileName);
			File file = new File(WEB_ROOT, fileName);
			System.out.println("\n\n\nThe user asked for resource: " + file);
			if (file.exists()) {
				// ������Ӧ���ĸ�ʽ����
				System.out.println(fileName + " start send");

				out.println("HTTP/1.0 200 OK");
				out.println("MIME_version:1.0");
				out.println("Content_Type:text/html");
				int len = (int) file.length();
				out.println("Content_Length:" + len);
				out.println("");// ����ͷ����Ϣ֮��Ҫ��һ��

				// �����ļ�
				sendFile(out, file);

				out.flush();
			}
			client.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}