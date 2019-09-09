package com.metacube.DI;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mockMailSender")
@Primary // 2.2 handling more than one candidate bean problem using @primary annotation on class 
public class MockMailSender implements MailSender {
	
	
	public void sendMail()
	{
		System.out.println("Mock Mail....");
	}
}
