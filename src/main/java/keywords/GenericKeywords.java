package keywords;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GenericKeywords {
	// 200
	public WebDriver driver = null;

	// 201, 203
	Properties prop = null;

	// 209
	public ExtentTest test;

	// 200
	public void openBrowser(String browser) {
		/*
		 * // 203 - Removed and added in ApplicationKeywords prop = new Properties();
		 * try { FileInputStream fStream = new FileInputStream(
		 * System.getProperty("user.dir") +
		 * "//src//test//resources//rediff.properties"); prop.load(fStream); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */

		String browserName = prop.getProperty(browser);
		test.log(Status.INFO, "Opening browser" + browser);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");

			// to open in incognito
			options.addArguments("--incognito");

			// to stop notification
			options.addArguments("--disable-notifications");

			// to disable certificate errors
			options.addArguments("ignore-certificate-errors");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	// 201
	public void closeBrowser() {
		driver.quit();
	}

	// 209
	public void setReport(ExtentTest test) {
		this.test = test;
	}

	// 200
	public void openURL(String URL) {
		// 209
		// test.log(Status.INFO, "Opening URL");
		logInfo("Opening URL");
		driver.get(prop.getProperty(URL));
	}

	// 201
	public void click(String Locator) {
		// driver.findElement(By.xpath(prop.getProperty(Locator))).click();
		// 209
		// test.log(Status.INFO, "Click on the locator " + prop.getProperty(Locator));
		logInfo("Click on the locator " + prop.getProperty(Locator));

		// 202
		getElement(Locator).click();
	}

	public void type(String Locator, String string) {
		// driver.findElement(By.xpath(prop.getProperty(Locator))).sendKeys(string);
		// 202
		logInfo("Print value");
		getElement(Locator).sendKeys(string);
	}

	public void enterCaptcha(String Locator) {
		logInfo("Enter captcha");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Captcha: ");
		String inputText = scanner.nextLine();

		// driver.findElement(getElement(Locator)).sendKeys(inputText);
		// 202
		driver.findElement(getLocator(Locator)).sendKeys(inputText);
	}

	// 202
	public WebElement getElement(String locatorKey) {
		// Element is present
		logInfo("Check element is present");
		if (!isElementPresent(locatorKey)) {
			// Report error
			System.out.println("Element is not present: " + locatorKey);
		}

		// Element is visible
		if (!isElementVisible(locatorKey)) {
			logInfo("Check element is visible");
			// Report error
			System.out.println("Element is not visible: " + locatorKey);
		}

		// Create a web element and return web element
		WebElement element = driver.findElement(getLocator(locatorKey));
		return element;
	}

	// 202
	public boolean isElementPresent(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean isElementVisible(String locatorName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorName)));

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 204
	public By getLocator(String locatorKey) {
		By by = null;

		if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(prop.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_id")) {
			by = By.id(prop.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_css")) {
			by = By.cssSelector(prop.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_linkText")) {
			by = By.linkText(prop.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_partialLinkText")) {
			by = By.partialLinkText(prop.getProperty(locatorKey));
		}
		return by;
	}

	// 209
	public void logInfo(String msg) {
		test.log(Status.INFO, msg);
	}

	// 209
	public void logError(String msg) {
		test.log(Status.FAIL, msg);
	}

	// 209
	public void logWarning(String msg) {
		test.log(Status.WARNING, msg);
	}

	// 209
	public void logSkip(String msg) {
		test.log(Status.SKIP, msg);
	}

	public void select() {

	}

	public void getText() {

	}

	public void navigate() {

	}

	public void acceptAlert() {

	}

	public void dismissAlert() {

	}

	public void quitDriver() {
		driver.quit();
	}
}
