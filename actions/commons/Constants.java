package commons;

public class Constants {

	public static final String FILE_SEPERATOR = System.getProperty("file.separator");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String URL = "https://openweathermap.org/";
	public static final String CHROME_DRIVER_PATH = FILE_SEPERATOR + "browserDrivers" + FILE_SEPERATOR + "chrome" + FILE_SEPERATOR + "chromedriver92";
	public static final String FIREFOX_DRIVER_PATH = FILE_SEPERATOR + "browserDrivers" + FILE_SEPERATOR + "firefox" + FILE_SEPERATOR + "geckodriver";
	public static final int TIMEOUT = 30;
}