package com.trial.demo;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class ReadEmailForOSISoft {

	public static String fetchVerificationCode(String pop3Host, String storeType, String user, String password) {
		String verificationCode = null;
		
//		Server name: outlook.office365.com
//		Port: 993
//		Encryption method: TLS
		
		try {
			// create properties field
			Properties properties = new Properties();
			properties.put("mail.store.protocol", "pop3");
			properties.put("mail.pop3.host", pop3Host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(pop3Host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			ArrayList<Message> messages = new ArrayList<Message>(Arrays.asList(emailFolder.getMessages()));
			System.out.println("messages.length---" + messages.size());

			// reverse List of emails to fetch most recent email first
			Collections.reverse(messages);
			String messageContent = null;

			String regExForVerificationCode = "Verification Code: \\d+";

			for (int i = 0; i < 5; i++) {
				System.out.println("---------------------------------");
				Message message = messages.get(i);
				System.out.println(message.getSubject());
				System.out.println(Arrays.asList(message.getFrom()).toString());
				if (message.getSubject()
						.contains("Verify your identity in Salesforce") && message.isMimeType("text/plain")) {
					System.out.println("***Found message for identity in Salesforce***");
					System.out.println("***" + "Date :- " + message.getSentDate() + "***");
					messageContent = (String) message.getContent();
					System.out.println(messageContent);
					Pattern pattern = Pattern.compile(regExForVerificationCode);
					Matcher matcher = pattern.matcher(messageContent);
					if (matcher.find()) {
						String verificationCodeSnippet = matcher.group(0);

						verificationCode = verificationCodeSnippet.substring(verificationCodeSnippet.indexOf(":") + 1)
								.trim();

						if (verificationCode.matches("\\d+")) {
							System.out.println("Verification code snippet -> " + verificationCodeSnippet);
							System.out.println("Verification code -> " + verificationCode);
							break;
						} else {
							System.out.println("Could not find verification code");
						}
					} else {
						System.out.println("Could not find verification code");
					}
				}
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return verificationCode;
	}

	public static void main(String[] args) {

		String host = "outlook.office365.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "@jadeglobal.com";// change accordingly
		String password = "asdfasfsfa";// change accordingly

		// Call method fetch
//		fetchVerificationCode(host, mailStoreType, new String(Base64.getDecoder().decode(username)),
//				new String(Base64.getDecoder().decode(password)));

		fetchVerificationCode(host, mailStoreType, username, password);

	}

	/*
	 * This method checks for content-type based on which, it processes and fetches
	 * the content of the message
	 */
	public static void writePart(Part p) throws Exception {
		if (p instanceof Message)
			// Call methos writeEnvelope
			writeEnvelope((Message) p);

		System.out.println("----------------------------");
		System.out.println("CONTENT-TYPE: " + p.getContentType());

		// check if the content is plain text
		if (p.isMimeType("text/plain")) {
			System.out.println("This is plain text");
			System.out.println("---------------------------");
			System.out.println((String) p.getContent());
		}
		// check if the content has attachment
		else if (p.isMimeType("multipart/*")) {
			System.out.println("This is a Multipart");
			System.out.println("---------------------------");
			Multipart mp = (Multipart) p.getContent();
			int count = mp.getCount();
			for (int i = 0; i < count; i++)
				writePart(mp.getBodyPart(i));
		}
		// check if the content is a nested message
		else if (p.isMimeType("message/rfc822")) {
			System.out.println("This is a Nested Message");
			System.out.println("---------------------------");
			writePart((Part) p.getContent());
		} else if (p.getContentType()
				.contains("image/")) {
			System.out.println("content type" + p.getContentType());
			File f = new File("image" + new Date().getTime() + ".jpg");
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			com.sun.mail.util.BASE64DecoderStream test = (com.sun.mail.util.BASE64DecoderStream) p.getContent();
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = test.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
		} else {
			Object o = p.getContent();
			if (o instanceof String) {
				System.out.println("This is a string");
				System.out.println("---------------------------");
				System.out.println((String) o);
			} else if (o instanceof InputStream) {
				System.out.println("This is just an input stream");
				System.out.println("---------------------------");
				InputStream is = (InputStream) o;
				is = (InputStream) o;
				int c;
				while ((c = is.read()) != -1)
					System.out.write(c);
			} else {
				System.out.println("This is an unknown type");
				System.out.println("---------------------------");
				System.out.println(o.toString());
			}
		}

	}

	/*
	 * This method would print FROM,TO and SUBJECT of the message
	 */
	public static void writeEnvelope(Message m) throws Exception {
		System.out.println("This is the message envelope");
		System.out.println("---------------------------");
		Address[] a;

		// FROM
		if ((a = m.getFrom()) != null) {
			for (int j = 0; j < a.length; j++)
				System.out.println("FROM: " + a[j].toString());
		}

		// TO
		if ((a = m.getRecipients(Message.RecipientType.TO)) != null) {
			for (int j = 0; j < a.length; j++)
				System.out.println("TO: " + a[j].toString());
		}

		// SUBJECT
		if (m.getSubject() != null)
			System.out.println("SUBJECT: " + m.getSubject());

	}
}