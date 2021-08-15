package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePage;

public class WeatherInYourCityPageObject extends BasePage {

	public WeatherInYourCityPageObject(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"forecast-list\"]//a")
	private WebElement firstCityLink;

	public void clickToFirstCityLink() {
		clickToElement(firstCityLink);
//		return PageGeneratorManager.getCityPage(driver);
	}

}