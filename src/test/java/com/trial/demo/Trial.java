package com.trial.demo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class Trial {

	public static void main(String[] args) throws Exception{
		
		String str = "Process 141593 was submitted.";
		System.out.println(StringUtils.substringBetween(str, "Process", "was submitted").trim());
		
		File file = new File(FileUtils.getTempDirectory().getAbsoluteFile() + "/temporary-directory");
		file.mkdir();
		
		System.out.println(file.getAbsolutePath());
		
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
		
	}

}
