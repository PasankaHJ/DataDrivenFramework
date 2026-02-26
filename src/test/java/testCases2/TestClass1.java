package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import testBase.BaseTestClass;

public class TestClass1 extends BaseTestClass{
	@Test
	public void method1() {
		// Ex: Login
		System.out.println("Method 1");
	}

	@Test
	public void method2(ITestContext con) {
		// Ex: Logout
		System.out.println("Method 2");
		//System.out.println(number);
		System.out.println(con.getAttribute(number));
		//app.openURL("URL"); // This not works yet
	}
}
