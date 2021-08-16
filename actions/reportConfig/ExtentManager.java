package reportConfig;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.Constants;
import listenerConfig.ExtentListener;

public class ExtentManager extends ExtentListener{

	static Date d = new Date();

	public static ExtentReports extent;
	public static volatile String fileName = d.toString().replace(":", "_").replace(" ", "_");
	public static volatile String reportFileName = fileName.concat(".html");
	public static String reportFilepath = Constants.PROJECT_PATH + Constants.FILE_SEPERATOR + "TestReports";
	public static String reportFileLocation = reportFilepath + Constants.FILE_SEPERATOR + reportFileName;
	public static String screenShotPath = Constants.PROJECT_PATH + Constants.FILE_SEPERATOR + "ScreenShots";
	public static volatile String screenShotFileName = fileName.concat(".png");
	public static volatile String screenShotFilePath = screenShotPath + Constants.FILE_SEPERATOR + screenShotFileName;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		String fileName = getReportPath(reportFilepath);

		createFolder(screenShotPath);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

	// Create the report path
	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				System.out.println("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		}
		return reportFileLocation;
	}

	private static void createFolder(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		}
	}

}
