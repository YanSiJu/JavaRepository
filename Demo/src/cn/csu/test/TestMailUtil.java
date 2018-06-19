package cn.csu.test;

import java.security.GeneralSecurityException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;


public class TestMailUtil {

	public static void main(String[] args) throws MessagingException, GeneralSecurityException {

		/*
		 * try { MailUtil.sendMail("913010012@qq.com", "Test email"); } catch
		 * (MessagingException | GeneralSecurityException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		Properties props = new Properties();

		// ����debug����
		props.setProperty("mail.debug", "true");
		// ���ͷ�������Ҫ�����֤
		props.setProperty("mail.smtp.auth", "true");
		// �����ʼ�������������
		props.setProperty("mail.host", "smtp.qq.com");
		// �����ʼ�Э������
		props.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(props);

		Message msg = new MimeMessage(session);
		msg.setSubject("seenews ����");
		StringBuilder builder = new StringBuilder();
		builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
		builder.append("\nҳ���������");
		builder.append("\nʱ�� " + System.currentTimeMillis());
		msg.setText(builder.toString());
		msg.setFrom(new InternetAddress("913010012@qq.com"));

		Transport transport = session.getTransport();
		transport.connect("smtp.qq.com", "913010012@qq.com", "ecbxmpmtjzsobech");

		transport.sendMessage(msg, new Address[] { new InternetAddress("1326641372@qq.com") });
		transport.close();
	}

}
