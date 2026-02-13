package testCases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;

@Test
public class CreatePortfolioTest extends ApplicationKeywords {

	public void createProtfolioTest() {
		ApplicationKeywords app = new ApplicationKeywords();

		// 200
		app.openBrowser("browser");
		app.openURL("URL");

		// 201
		app.click("signIn_L");

		// 201 - Enter username
		app.type("username_L", "username");

		// 201 - Enter password
		app.type("password_L", "password");

		
		app.closeBrowser();

	}
}
