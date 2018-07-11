package cn.csu.server;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	public static void main(String[] args) {
		int Port = 12345;// �˿ںţ����������ǲ��ԣ����Բ�Ҫʹ�ó��ö˿�
		// ���������׽���
		ServerSocket server = null;
		Socket client = null;
		try {
			server = new ServerSocket(Port);
			// ��������ʼ����
			System.out.println("The WebServer is listening on port " + server.getLocalPort());
			while (true) {
				client = server.accept();
				// ���߳�����
				new CommunicateThread(client).start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
