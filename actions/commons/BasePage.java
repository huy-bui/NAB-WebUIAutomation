package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Web Browser
	
	public void openPageURL(String url) {
		driver.get(url);
	}
	
	public void sleepInSecond(long timeSleep) {
		try {
			Thread.sleep(timeSleep*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sleepInMiliSecond(long timeSleep) {
		try {
			Thread.sleep(timeSleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Alert waitForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.dismiss();
	}
	
	// Web Element
	
	public void clickToElement(WebElement element) {
		waitForElementClickable(element);
		element.click();
	}
	
	public void sendKeysToElement(WebElement element, String value) {
		waitForElementVisible(element);
		element.clear();
		element.sendKeys(value);
	}
	
	public String getTextElement(WebElement element) {
		waitForElementVisible(element);
		return element.getText();
	}
	
	public boolean isElementEnbaled(WebElement element) {
		waitForElementVisible(element);
		return element.isEnabled();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	// Actions
	
	public void pressKeyToElement(WebElement element, Keys keyboard) {
		actions = new Actions(driver);
		actions.sendKeys(element, keyboard).perform();
	}

	// Wait handling
	
	public void waitForElementVisible(WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAllElementsVisible(WebElement elements) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForElementClickable(WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementInvisible(WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	private Alert alert;
	private Actions actions;
	private long timeout = 30;
	private WebDriverWait explicitWait;
}