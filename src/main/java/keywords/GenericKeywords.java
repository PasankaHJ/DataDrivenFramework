package keywords;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GenericKeywords {
	// 200
	public WebDriver driver = null;

	// 201
	Properties prop = null;

	// 200
	public void openBrowser(String browser) {
		prop = new Properties();
		try {
			FileInputStream fStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//rediff.properties");
			prop.load(fStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty(browser);
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
	
	//201
	public void closeBrowser(){
		driver.quit();
	}

	// 200
	public void openURL(String URL) {
		driver.get(prop.getProperty(URL));
	}

	// 201
	public void click(String Locator) {
		driver.findElement(By.xpath(prop.getProperty(Locator))).click();
	}

	public void type(String Locator, String string) {
		driver.findElement(By.xpath(prop.getProperty(Locator))).sendKeys(string);
	}
	
	public void enterCaptcha(String Locator) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Captcha: ");
		String inputText = scanner.nextLine();
		
		driver.findElement(By.xpath(prop.getProperty(Locator))).sendKeys(inputText);
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
}
