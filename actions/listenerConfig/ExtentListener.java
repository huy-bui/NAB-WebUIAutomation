package listenerConfig;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commons.BaseTest;
import reportConfig.ExtentManager;
import reportConfig.ExtentTestManager;

public class ExtentListener extends BaseTest implements ITestListener{
	
	public void onStart(ITestContext context) {
		System.out.println("=== Test Suite " + context.getName() + " starting...");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("=== Test Suite " + context.getName() + " end!"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("=== Test case: " + result.getMethod().getMethodName() + " running..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + methodName.toUpperCase() + " => PASSED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        Markup n = MarkupHelper.createLabel("Run on: " + browser.toUpperCase(), ExtentColor.BLUE);
        System.out.println("=== RESULT: " + result.getMethod().getMethodName() + " => PASSED");
        ExtentTestManager.getTest().log(Status.PASS, m);
        ExtentTestManager.getTest().log(Status.PASS, n);
	}

	public void onTestFailure(ITestResult result){
		String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + methodName.toUpperCase() + " => FAILED" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		System.out.println("=== RESULT: " + result.getMethod().getMethodName() + " => FAILED");
		ExtentTestManager.getTest().log(Status.FAIL, m);
		Markup n = MarkupHelper.createLabel("Run on: " + browser.toUpperCase(), ExtentColor.BLUE);
		ExtentTestManager.getTest().log(Status.FAIL, n);
		
		String exceptionMessage = result.getThrowable().toString();
		String failMessage = "<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see"
                + "</font>" + "</b >" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>" + " \n";
		ExtentTestManager.getTest().log(Status.FAIL, failMessage);
        
//        String encodedBase64 = null;
//		try {
//			encodedBase64 = ImageUtils.getBase64StringFromImage(takeScreenShot());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		String image = "<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>" + "\n"
//              + "<img style='width:auto;max-width:25%;height:auto;max-height:25%;' "
//              + "src='data:img/png;base64,"
//              + encodedBase64 + "'" + "/>";
//		ExtentTestManager.getTest().log(Status.FAIL, image);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		System.out.println("=== RESULT: " + result.getMethod().getMethodName() + " => SKIPPED");
		ExtentTestManager.getTest().log(Status.SKIP, m);
		Markup n = MarkupHelper.createLabel("Run on: " + browser.toUpperCase(), ExtentColor.BLUE);
		ExtentTestManager.getTest().log(Status.SKIP, n);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
	
//	public synchronized String takeScreenShot() {
//		// Take the screenshot
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		// Copy the file to a location and use try catch block to handle exception
//		try {
//			FileUtils.copyFile(screenshot, new File(ExtentManager.screenShotFilePath));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		return ExtentManager.screenShotFilePath;
//	}
}

