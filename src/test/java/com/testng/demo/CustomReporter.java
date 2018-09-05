package com.testng.demo;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class CustomReporter extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		Reporter.log("Failed");
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		Reporter.log("Skipped");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		Reporter.log("Pass");
	}

}
