package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.BaseTestClass;

public class TestClass1 extends BaseTestClass{
	@Test
	public void method1() {
		// Ex: Login
		System.out.println("Method 1");
	}

	@Test
	public void createPortfolio() { // 208 - removed ITestContext
		extentTest.log(Status.INFO, "Create Portfolio");
		
	}
}
