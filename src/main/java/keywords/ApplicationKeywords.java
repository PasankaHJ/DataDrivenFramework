package keywords;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class ApplicationKeywords extends ValidationKeywords {
	// 203
	public ApplicationKeywords() {
		prop = new Properties();
		try {
			/*
			 * Rediff
			FileInputStream fStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//rediff.properties");
			*/
			
			// Orange HRM
			FileInputStream fStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//orangeHRM.properties");
			
			prop.load(fStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//210
		softAssert = new SoftAssert();
	}

	public void login() {

	}

	public void selectDateFromCalendar(String date) {
		logInfo("Selecting the Date: " + date);
		
		try {
			Date currentDate = new Date();
			SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date dateToSelect = dFormat.parse(date);
			
			String day = new SimpleDateFormat("d").format(dateToSelect); // Single digit date, otherwise dd
			String month = new SimpleDateFormat("MMMM").format(dateToSelect);
			String year = new SimpleDateFormat("yyyy").format(dateToSelect);
			
			String monthYearToBeSelected = month + " " + year;
			String monthYearToBeDisplayed = getElement("add the locator here").getText();
			
			while(!monthYearToBeSelected.equals(monthYearToBeDisplayed)) {
				click("add the locator here"); // Calendar back/fronts arrow
				monthYearToBeDisplayed = getElement("add the locator here").getText();
			}
			
			// Select date
			driver.findElement(By.xpath("dynamic xpath='" + day+ "']")).click();
		} catch (ParseException e) {
			logError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public int getRowNumWithCellQuantity(String locatorKey, String data) {
		WebElement table = getElement(locatorKey);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int rNum= 0; rNum < rows.size(); rNum++) {
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum= 0; cNum < rows.size(); cNum++) {
				WebElement cell = rows.get(cNum);
				if(!cell.getText().trim().equals("")) {
					if(cell.getText().contains(data)) {
						return (rNum);
					}
				}
			}
		}
		return -1; // data is not found
	}
	
	
	
	
}
