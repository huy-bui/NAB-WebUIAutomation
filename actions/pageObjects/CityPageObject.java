package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;

public class CityPageObject extends BasePage {

	public CityPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.grey-container+div span.orange-text")
	private WebElement currentDateTime;

	@FindBy(css = "div.grey-container+div h2")
	private WebElement cityName;

	@FindBy(xpath = "//div[@class=\"current-temp\"]//span")
	private WebElement temperatureText;

	@FindBy(xpath = "//div[@class=\"owm-loader-container\"]")
	private WebElement loadingIcon;

	public void waitForLoadingIconInvisible() {
		waitForElementInvisible(loadingIcon);
	}

	public String getCurrentDateTime() {
		return getTextElement(currentDateTime);
	}

	public String getCityName() {
		return getTextElement(cityName);
	}

	public String getTemperature() {
		return getTextElement(temperatureText);
	}

	public boolean isTemperatureDisplayed() {
		return isElementDisplayed(temperatureText);
	}

	public boolean isCityDisplayed() {
		return isElementDisplayed(cityName);
	}

	public boolean isCurrentDateTimeDisplayed() {
		waitForLoadingIconInvisible();
		return isElementDisplayed(currentDateTime);
	}
}
