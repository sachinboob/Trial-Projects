package com.testng.demo;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

	static {
		Reporter.setEscapeHtml(true);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("In Before Method");
	}

	@Test(priority = 4, groups = { "sanity" })
	public void method1() {
		System.out.println("In method1");
		Reporter.log("<Report - In method1>");
	}

	@Test(priority = 1, groups = { "sanity" })
	public void method3() {
		System.out.println("In method3");
		Reporter.log("<Report - In method3>");
	}

	@Test(priority = 3, groups = { "regression" })
	public void method2() {
		System.out.println("In method2");
		Reporter.log("<Report - In method2>");
	}

	@Test(priority = 2, groups = { "new_func" })
	public void method4() {
		System.out.println("In method4");
		Reporter.log("<Report - In method4>");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("In After Method");
	}
}