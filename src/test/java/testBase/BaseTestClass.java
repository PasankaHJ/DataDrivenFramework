package testBase;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import keywords.ApplicationKeywords;
import reports.ExtentManager;

public class BaseTestClass {
	public ApplicationKeywords app;
	public String number = "numKey";
	public ExtentReports extentReport;
	public ExtentTest extentTest;


	@BeforeTest
	public void beforeTest(ITestContext context) {
		System.out.println("BaseTestClass beforeTest");
		// 207
		// Single app object for single test
		// Initialize and share for all the test cases
		app = new ApplicationKeywords();
		context.setAttribute("app", app);

		// 208
		// Init reports
		extentReport = ExtentManager.getReports();
		extentTest = extentReport.createTest(context.getCurrentXmlTest().getName());
		extentTest.log(Status.INFO, "Starting Test: " + context.getCurrentXmlTest().getName());
		
		// 209
		app.setReport(extentTest);
		
		context.setAttribute("extentReport", extentReport);
		context.setAttribute("extentTest", extentTest);
	}

	@AfterTest
	public void afterTest(ITestContext context) {
		System.out.println("BaseTestClass afterTest");
		app = (ApplicationKeywords) context.getAttribute("app");
		if (app != null) {
			app.quitDriver();
		}

		// 208
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		if (extentReport != null) {
			extentReport.flush(); // Save report
		}

	}

	@BeforeMethod(alwaysRun = true)
	public void berforeMethod(ITestContext context) {
		System.out.println("BaseTestClass berforeMethod");

		// 207
		// 208 - removed ApplicationKeywords before app
		app = (ApplicationKeywords) context.getAttribute("app");
		extentReport = (ExtentReports) context.getAttribute("extentReport");
		extentTest = (ExtentTest) context.getAttribute("extentTest");
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("BaseTestClass afterMethod");
	}
}
