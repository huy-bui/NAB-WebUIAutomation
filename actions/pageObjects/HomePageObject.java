package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;

public class HomePageObject extends BasePage {

	public HomePageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div#desktop-menu input[name='q']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//div[@class=\"owm-loader-container\"]")
	private WebElement loadingIcon;

	public void waitForLoadingIconInvisible() {
		waitForElementInvisible(loadingIcon);
	}

	public WeatherInYourCityPageObject inputCityNameAndSearch(String cityName) {
		waitForLoadingIconInvisible();
		sendKeysToElement(searchTextBox, cityName);
		sleepInSecond(1);
		pressKeyToElement(searchTextBox, Keys.ENTER);
		return new WeatherInYourCityPageObject(driver);
	}

}