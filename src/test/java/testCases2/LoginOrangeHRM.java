package testCases2;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import testBase.BaseTestClass;

public class LoginOrangeHRM extends BaseTestClass{
	@Test
	public void loginOHRM() {
		extentTest.log(Status.INFO, "Login Test");
		app.logInfo("Login Test");
		extentTest.log(Status.INFO, "Open Browser");
		app.openBrowser("browser");
		app.openURL("URL");
		app.waitForElement("username_L_xpath");
		app.isElementPresent("username_L_xpath");
		app.type("username_L_xpath", "username");
		app.type("password_L_xpath", "password");
		app.waitForElement("btnLogin_L_xpath");
		app.click("btnLogin_L_xpath");
		app.reportAll();
	}
}
