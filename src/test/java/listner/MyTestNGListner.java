package listner;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

// 213
public class MyTestNGListner implements ITestListener {

	// This function is called when ever a test case (@Test) fails
	public void onTestFailure(ITestResult result) {
		System.out.println("***** TEST FAIL*****");
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.fail(result.getThrowable().getMessage());
	}

	// This function is called when ever a test case (@Test) success
	public void onTestSuccess(ITestResult result) {
		System.out.println("***** TEST SUCCESS*****");
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.pass("Test Success: " + result.getName());
	}

	// This function is called when ever a test case (@Test) skips
	public void onTestSkiped(ITestResult result) {
		System.out.println("***** TEST SKIPPED*****");
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("extentTest");
		test.fail(result.getName() + " test Skipped due to critical error in previous test.");
	}
}
