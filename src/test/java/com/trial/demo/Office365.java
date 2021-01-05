package com.trial.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

public class Office365 {
	
	private static Properties props;  
	private static Session emailSession;   
	static {      
	  props = new Properties();
	  props.put("mail.store.protocol", "pop3");
	  props.put("mail.pop3.host", "outlook.office365.com");
	  props.put("mail.pop3.port", "995");
//	  props.put("mail.pop3.starttls.enable", "true");
//	props.put("mail.pop3s.ssl.trust", "*");
//	  props.put("mail.smtp.starttls.enable", "true");
//	  props.put("mail.smtp.port", "587");
//	  props.put("mail.smtp.host", "smtp.office365.com");
//	  props.put("mail.smtp.auth", "true");        
	  emailSession = Session.getInstance(props, new Authenticator() {          
	      @Override
	      protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication("sachin.boob@jadeglobal.com",
	                  "Jade@1989");          
	      }       
	  });

	}

	public static void main(String[] args) throws Exception {
		
		emailSession.setDebug(true);

		// create the POP3 store object and connect with the pop server
		Store store = emailSession.getStore("pop3s");

		store.connect("outlook.office365.com", "sachin.boob@jadeglobal.com", "Jade@1989");

		// create the folder object and open it
		Folder emailFolder = store.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);

		// retrieve the messages from the folder in an array and print it
		ArrayList<Message> messages = new ArrayList<Message>(Arrays.asList(emailFolder.getMessages()));
		System.out.println("messages.length---" + messages.size());


	}

}
