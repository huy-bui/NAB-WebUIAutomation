package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager{

	private volatile static HomePageObject homePage;
	private volatile static CityPageObject cityPage;
	private volatile static WeatherInYourCityPageObject weatherInYourCityPage;

	private PageGeneratorManager() {
	}

	public static synchronized HomePageObject getHomePage(WebDriver driver) {
		if (homePage == null) {
			homePage = new HomePageObject(driver);
		}
		return homePage;
	}

	public static synchronized CityPageObject getCityPage(WebDriver driver) {
		if (cityPage == null) {
			cityPage = new CityPageObject(driver);
		}
		return cityPage;
	}

	public static synchronized WeatherInYourCityPageObject getWeatherInYourCityPage(WebDriver driver) {
		if (weatherInYourCityPage == null) {
			weatherInYourCityPage = new WeatherInYourCityPageObject(driver);
		}
		return weatherInYourCityPage;
	}
}
