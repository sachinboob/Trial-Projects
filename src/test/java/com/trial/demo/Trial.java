package com.trial.demo;

import static org.testng.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Trial {

	public static void main(String[] args) throws Exception {
//		
//		String str = "Process 141593 was submitted.";
//		System.out.println(StringUtils.substringBetween(str, "Process", "was submitted").trim());
//		
//		File file = new File(FileUtils.getTempDirectory().getAbsoluteFile() + "/temporary-directory");
//		file.mkdir();
//		
//		System.out.println(file.getAbsolutePath());
//		
//		System.out.println(RandomStringUtils.randomAlphanumeric(10));
//		System.out.println(RandomStringUtils.randomAlphanumeric(10));
//		System.out.println(RandomStringUtils.randomAlphanumeric(10));
//		System.out.println(RandomStringUtils.randomAlphanumeric(10));

		System.out.println(new SimpleDateFormat("dd MMM yyyy HH:mm:ss z").format(new Date()));


	}

}
