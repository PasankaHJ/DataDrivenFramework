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
	public void method2() { // 208 - removed ITestContext
		// Ex: Logout
		// 208
		extentTest.log(Status.INFO, "Create Portfolio");
		System.out.println("Method 2");
		//System.out.println(number);
		//System.out.println(con.getAttribute(number));
		
		// 208
		//extentTest.log(Status.INFO, "Open Website URL");
		//app.openURL("URL");
	}
}
