package keywords;

import java.io.FileInputStream;
import java.util.Properties;

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
	}

	public void login() {

	}

	public void selectDate() {

	}
}
