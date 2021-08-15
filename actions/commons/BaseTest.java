package commons;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;
	public String currentDir = System.getProperty("user.dir");

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browserName) {
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", currentDir + Constants.CHROME_DRIVER_PATH);
			ChromeOptions chromeOptions = new ChromeOptions();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("profile.default_content_settings.geolocation", 2);
			jsonObject.put("profile.default_content_setting_values.cookies", 2);
			chromeOptions.setExperimentalOption("prefs", jsonObject);
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", currentDir + Constants.FIREFOX_DRIVER_PATH);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("geo.enabled", false);
			profile.setPreference("geo.provider.use_corelocation", false);
			profile.setPreference("network.cookie.cookieBehavior", 2);
			FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(profile);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		default:
			throw new RuntimeException("Invalid browser name. Please check again!");
		}

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
