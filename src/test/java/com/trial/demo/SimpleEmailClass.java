package com.trial.demo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class SimpleEmailClass {

	public static void main(String[] args)throws Exception {

		Email email = new SimpleEmail();
		email.setHostName("outlook.office365.com");
//		email.setSmtpPort(587);
		
//		email.setHostName("smtp.googlemail.com");
//		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sachin.boob@jadeglobal.com", "Jade@1989"));
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		email.setFrom("sachin.boob@jadeglobal.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("sachin.boob@jadeglobal.com");
		email.send();
		
	}

}
