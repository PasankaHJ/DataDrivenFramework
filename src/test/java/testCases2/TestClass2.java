package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import testBase.BaseTestClass;

public class TestClass2 extends BaseTestClass{
	@Test
	public void method3() {
		System.out.println("Method 3");

	}

	@Test
	public void method4(ITestContext con) {
		System.out.println("Method 4");
		//number = 2000;
		//System.out.println(number);
		
		//207
		//con.setAttribute(number, 3000);
		app.openBrowser("browser");
	}

	@Test
	public void method5() {
		System.out.println("Method 5");

	}
}
