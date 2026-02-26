package testBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import keywords.ApplicationKeywords;

public class BaseTestClass {
	public ApplicationKeywords app;
	public int number;

	@BeforeMethod(alwaysRun = true)
	public void berforeMethod() {
		System.out.println("BaseTestClass berforeMethod");
		number = 1000;
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("BaseTestClass afterMethod");
	}
}
