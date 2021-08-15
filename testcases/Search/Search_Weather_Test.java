package Search;

import org.testng.Assert;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CityPageObject;
import pageObjects.HomePageObject;
import pageObjects.WeatherInYourCityPageObject;
import utils.Helper;

public class Search_Weather_Test extends BaseTest {

	HomePageObject homePage;
	WeatherInYourCityPageObject weatherInYourCityPage;
	CityPageObject cityPage;

	@Test
	public void Search_Weather_In_A_City() {
		String city = "Ha Noi";
		String expectedCityName = city.trim().replace(" ", "").toLowerCase();

		homePage = new HomePageObject(driver);
		homePage.inputCityNameAndSearch(city);

		weatherInYourCityPage = new WeatherInYourCityPageObject(driver);
		weatherInYourCityPage.clickToFirstCityLink();
		
		cityPage = new CityPageObject(driver);
		Helper helper = Helper.initialHelper();
		String systemCurrentDate = helper.getCurrentDate();

		Assert.assertTrue(cityPage.isCurrentDateTimeDisplayed(), "Current date time is NOT displayed!!!");
		Assert.assertTrue(cityPage.getCurrentDateTime().contains(systemCurrentDate),
				"Current date is displayed incorrectly!!!");
		Assert.assertTrue(cityPage.isCityDisplayed(), "City is NOT displayed!!!");
		String actualCityName = cityPage.getCityName().trim().replace(" ", "").toLowerCase();
		Assert.assertTrue(actualCityName.contains(expectedCityName), "City name is displayed incorrectly!!!");
		Assert.assertTrue(cityPage.isTemperatureDisplayed(), "Temperature is NOT displayed!!!");
		Assert.assertTrue(cityPage.getTemperature().contains("°C"), "Temperature is displayed incorrectly!!!");
	}
}
