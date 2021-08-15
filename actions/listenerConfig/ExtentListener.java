package listenerConfig;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import reportConfig.ExtentManager;
import reportConfig.ExtentTestManager;

public class ExtentListener implements ITestListener{

	public void onStart(ITestContext context) {
		System.out.println("=== Test Suite " + context.getName() + " starting...");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("=== Test Suite " + context.getName() + " end!"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("=== Test case: " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=== RESULT: " + result.getMethod().getMethodName() + " => PASSED");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** RESULT: " + result.getMethod().getMethodName() + " => FAILED");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** RESULT: " + result.getMethod().getMethodName() + " => SKIPPED");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("=== Test failed but within percentage % " + result.getMethod().getMethodName());
	}
	
}

