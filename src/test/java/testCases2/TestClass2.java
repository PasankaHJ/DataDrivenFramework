package testCases2;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import testBase.BaseTestClass;

public class TestClass2 extends BaseTestClass {
	@Test
	public void method3() {
		System.out.println("Method 3");

	}

	@Test
	public void method4() { // 208 - removed ITestContext
		System.out.println("Method 4");

		extentTest.log(Status.INFO, "Login Test");
		app.logInfo("Login Test");
		// number = 2000;
		// System.out.println(number);

		// 207
		// con.setAttribute(number, 3000);
		// extentTest.log(Status.INFO, "Open Browser");
		// app.openBrowser("browser");
		// app.openURL("URL");
		extentTest.log(Status.INFO, "Open Browser");
		app.openBrowser("browser");
		app.openURL("URL");
		// 211
		//app.reportFailure("Unable to load application", false);
		app.click("signIn_L_xpath");
		app.type("username_L_xpath", "username");
		// 210
		// Failure
		// 211
		//app.reportFailure("Unable to enter password", true);
		app.type("password_L_xpath", "password");
		app.enterCaptcha("captcha_L_xpath");
		
		// 213
		//app.reportAll();

	}

	@Test
	public void method5() {
		System.out.println("Method 5");

	}
}
