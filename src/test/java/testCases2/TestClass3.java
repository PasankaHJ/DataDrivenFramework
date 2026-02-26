package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import testBase.BaseTestClass;

public class TestClass3 extends BaseTestClass{
	@Test
	public void method6(ITestContext con) {
		System.out.println("Method 6");
		
		// 207
		//ApplicationKeywords app = (ApplicationKeywords) con.getAttribute("app");
		app.openBrowser("browser");
		app.openURL("URL");
	}
}
