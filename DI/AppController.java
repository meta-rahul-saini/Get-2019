package com.metacube.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */

@Component // @component annotation specifies that this class is eligible for component scanning
public class AppController
{

	//2.3 handling more than one candidate bean problem using Bean qualifiers
	@Qualifier("mockMailSender")  
	private MailSender mail;
	
	public AppController() {
		super();
	}
	
	//1.1 dependency injection by using constructor
	@Autowired	
	public AppController(MailSender mail) {
		System.out.println("constructor called ....");
		this.mail = mail;
	}
	
	
	
	
	//1.2 dependency injection by setter method
    @Autowired	
	@Primary
    public void setMail(MailSender mail) {
		System.out.println("setter method called....");
		this.mail = mail;
	}

    public MailSender getMail() {
		return mail;
	}
    
    
    // 2.1 handle more than one candidate beans problem using DI by name

//	@Autowired	
//	public AppController(MailSender SMTPMailSender) {
//		System.out.println("constructor called ....");
//		this.mail = mail;
//	}
//	
//	@Autowired	// dependency injection by using name
//	public AppController(MailSender mockMailSender) {
//		System.out.println("constructor called ....");
//		this.mail = mail;
//	}

}
