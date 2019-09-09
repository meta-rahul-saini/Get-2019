package com.metacube.DI;

import org.springframework.stereotype.Component;

@Component
public interface MailSender {

	public void sendMail();
}
