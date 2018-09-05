package com.testng.demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGDemo {

	static {
		Reporter.setEscapeHtml(true);
	}

	@Test(groups = { "sanity" })
	public void method1() {
		System.out.println("In method1");
		Reporter.log("<Report - In method1>");
	}

	@Test(groups = { "sanity" })
	public void method3() {
		System.out.println("In method3");
		Reporter.log("<Report - In method3>");
	}

	@Test(groups = { "regression" })
	public void method2() {
		System.out.println("In method2");
		Reporter.log("<Report - In method2>");
	}

	@Test(groups = { "new_func" })
	public void method4() {
		System.out.println("In method4");
		Reporter.log("<Report - In method4>");
	}
}