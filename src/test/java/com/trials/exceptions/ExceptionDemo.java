package com.trials.exceptions;

import org.openqa.selenium.StaleElementReferenceException;

public class ExceptionDemo {

	private static final int MAX_RETRY = 3;

	public static void main(String[] args) throws Exception {
		int attempt = 1;

		do {
			try {
				System.out.println("In Try block...");
				throw new Exception("asdfadf");
//				break;
			} catch (StaleElementReferenceException e) {
				attempt++;
				System.out.println("StaleElementReferenceException! Retrying the operation...");
				continue;
			} catch (Exception e) {
				throw e;
			} finally {
				System.out.println("In Finally block...");
			}
		} while (attempt <= MAX_RETRY);
	}
}
