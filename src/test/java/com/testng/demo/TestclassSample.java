package com.testng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestclassSample {

	private static int failureCount = 0;

	@Test(retryAnalyzer = MyRetry.class)
	public void test2() {

		if (failureCount != 2) {
			failureCount++;
			Assert.fail();
		}
	}
}
