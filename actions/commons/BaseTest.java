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

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObject;

public class BaseTest {

	protected WebDriver driver;
	protected HomePageObject homePage;
	protected static String browser = null;

	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browserName) {

		browser = browserName;
		switch (browserName.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("profile.default_content_settings.geolocation", 2);
			jsonObject.put("profile.default_content_setting_values.cookies", 2);
			chromeOptions.setExperimentalOption("prefs", jsonObject);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("geo.enabled", false);
			profile.setPreference("geo.provider.use_corelocation", false);
			profile.setPreference("network.cookie.cookieBehavior", 2);
			FirefoxOptions firefoxOptions = new FirefoxOptions().setProfile(profile);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		default:
			throw new RuntimeException("Invalid browser name. Please check again!");
		}

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
