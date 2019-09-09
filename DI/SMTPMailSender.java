package com.metacube.DI;

import org.springframework.stereotype.Component;

@Component("smtpMailSender")
public class SMTPMailSender implements MailSender {

	public void sendMail() {
		System.out.println("SMTP mail....");
	}

}
