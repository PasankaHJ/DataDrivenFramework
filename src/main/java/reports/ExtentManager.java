package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports reports;

	// 208
	// Initialize and Create Report
	public static ExtentReports getReports() {
		if (reports == null) {
			reports = new ExtentReports();

			// For file name
			Date date = new Date();
			String reportFolderName = date.toString().replaceAll(":", "_").replaceAll(" ", "-");
			System.out.println(reportFolderName);

			String reportPath = System.getProperty("user.dir") + "//reports//" + reportFolderName;

			String screenShotPath = reportPath + "/screenshots";

			// To create directories
			File file = new File(screenShotPath);
			file.mkdirs();

			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setTheme(Theme.STANDARD);
			reporter.config().setReportName("Poduction Test Report");
			reporter.config().setDocumentTitle("Data Driven Test Report");
			reporter.config().setEncoding("utf-8");

			reports.attachReporter(reporter);
		}
		return reports;
	}
}
