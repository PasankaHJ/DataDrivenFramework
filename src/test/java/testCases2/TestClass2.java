package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import testBase.BaseTestClass;

public class TestClass2 extends BaseTestClass{
	@Test
	public void method3() {
		System.out.println("Method 3");

	}

	@Test
	public void method4() { // 208 - removed ITestContext
		System.out.println("Method 4");
		
		extentTest.log(Status.INFO, "Login Test");
		//number = 2000;
		//System.out.println(number);
		
		//207
		//con.setAttribute(number, 3000);
		extentTest.log(Status.INFO, "Open Browser");
		app.openBrowser("browser");
	}

	@Test
	public void method5() {
		System.out.println("Method 5");

	}
}
