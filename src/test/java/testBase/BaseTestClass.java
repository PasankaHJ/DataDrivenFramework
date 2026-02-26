package testBase;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import keywords.ApplicationKeywords;

public class BaseTestClass {
	public ApplicationKeywords app;
	public String number = "numKey";

	@BeforeTest
	public void beforeTest(ITestContext context) {
		System.out.println("BaseTestClass beforeTest");
		// 207
		// Single app object for single test
		// Initialize and share for all the test cases
		app = new ApplicationKeywords();
		context.setAttribute("app", app);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseTestClass afterTest");
	}

	@BeforeMethod(alwaysRun = true)
	public void berforeMethod(ITestContext context) {
		System.out.println("BaseTestClass berforeMethod");
		
		//207 
		ApplicationKeywords app = (ApplicationKeywords) context.getAttribute("app");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("BaseTestClass afterMethod");
	}
}
