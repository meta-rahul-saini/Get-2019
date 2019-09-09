package com.metacube.DI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.metacube.DI")
public class Config {

	@Bean // this annotation specifies that whenever we need to get beans of type 'MailSender (return type)' it executes this method and returns MailSender object reference 
	public MailSender smtpMailSender() {
		return new SMTPMailSender();
	}
	
	// 2.2 handling more than one candidate bean problem using @primary annotation
	@Bean
	@Primary 	
	public MailSender mockMailSender() {
		return new MockMailSender();   
	}

}
