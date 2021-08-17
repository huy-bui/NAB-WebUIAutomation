package Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.BaseTest;
import pageObjects.CityPageObject;
import pageObjects.WeatherInYourCityPageObject;
import utils.Helper;

public class Search_Weather_Test extends BaseTest {

	WeatherInYourCityPageObject weatherInYourCityPage;
	CityPageObject cityPage;

	@Test
	public void Search_Weather_In_A_City() {
		String city = "Ha Noi";
		String expectedCityName = city.trim().replace(" ", "").toLowerCase();

		weatherInYourCityPage = homePage.inputCityNameAndSearch(city);

		cityPage = weatherInYourCityPage.clickToFirstCityLink();

		Helper helper = Helper.initialHelper();
		String systemCurrentDate = helper.getCurrentDate();
		
		String actualCurrentDate = cityPage.getCurrentDateTime();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cityPage.isCurrentDateTimeDisplayed(), "Current date time is NOT displayed!!!");
		softAssert.assertTrue(actualCurrentDate.contains(systemCurrentDate),
				"Expected date displays is " + systemCurrentDate + ", but actual date is " + actualCurrentDate);
		softAssert.assertTrue(cityPage.isCityDisplayed(), "City is NOT displayed!!!");
		String actualCityName = cityPage.getCityName().trim().replace(" ", "").toLowerCase();
		softAssert.assertTrue(actualCityName.contains(expectedCityName), 
				"Expected city name is " + expectedCityName + ", but actual city name is " + actualCityName);
		softAssert.assertTrue(cityPage.isTemperatureDisplayed(), "Temperature is NOT displayed!!!");
		softAssert.assertTrue(cityPage.getTemperature().contains("°C"), "Temperature does NOT contain °C");
		softAssert.assertAll();
	}
}
