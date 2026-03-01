package keywords;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

public class ApplicationKeywords extends ValidationKeywords {
	// 203
	public ApplicationKeywords() {
		prop = new Properties();
		try {
			FileInputStream fStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//rediff.properties");
			prop.load(fStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//210
		softAssert = new SoftAssert();
	}

	public void login() {

	}

	public void selectDate() {

	}
}
