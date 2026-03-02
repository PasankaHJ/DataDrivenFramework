package testCases2;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import testBase.BaseTestClass;

public class AddEducation  extends BaseTestClass{
	public void navigateEdu() {
		extentTest.log(Status.INFO, "Navigate to Education");
		app.waitForElement("menuAdmin_L_xpath");
		app.logInfo("Click Admin menu");
		app.click("menuAdmin_L_xpath");
		app.waitForElement("subMenuQualifications_L_xpath");
		app.logInfo("Click on Qualifications");
		app.click("subMenuQualifications_L_xpath");
		app.waitForElement("subMenuEducation_L_xpath");
		app.logInfo("Click on Education");
		app.click("subMenuEducation_L_xpath");
	}
	
	@Test
	public void addEdu() {
		extentTest.log(Status.INFO, "Add Education");
		
	}
}
