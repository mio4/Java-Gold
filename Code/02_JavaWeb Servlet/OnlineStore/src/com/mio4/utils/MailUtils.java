package com.mio4.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 用于发送邮件的工具类
 */
public class MailUtils {

	/**
	 *
	 * @param email 接受者账号
	 * @param emailMsg 邮件内容
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		//设置发送的协议
		props.setProperty("mail.transport.protocol", "SMTP"); //使用SMTP协议
		
		//设置发送邮件的服务器
		props.setProperty("mail.host", "localhost"); //本地发送
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//设置发送人的帐号和密码
				//e.g. 从service账号发送邮件
				return new PasswordAuthentication("service", "123");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		//设置发送者
		message.setFrom(new InternetAddress("service@store.com"));

		//设置发送方式与接收者
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); 

		//设置邮件主题
		message.setSubject("用户激活");
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		//设置邮件内容
		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);
	}
}
