package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverCustom {
	private final WebDriver driver;
	private final Wait<WebDriver> wait;
	public WebDriverCustom(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15L))
				.pollingEvery(Duration.ofSeconds(1L))
				.ignoring(NoSuchElementException.class);
	}

	/**
	 * get default web driver
	 * @return webDriver
	 */
	public WebDriver getWebDriver() {
		return this.driver;
	}

	/**
	 * getPresenceWebElement - get web element presence in DOM
	 * @param xpath - xpath for webElement
	 * @return webElement
	 */
	public WebElement getPresenceWebElement(String xpath) {
		return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * getVisibleWebElement - get web element visible in DOM
	 * @param xpath - xpath for webElement
	 * @return webElement
	 */
	public WebElement getVisibleWebElement(String xpath) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	/**
	 * isElementInvisible - wait for invisible of web element in DOM and result result if it is invisible or not
	 * @param xpath - xpath for webElement
	 * @return true if web element is invisible 
	 */
	public boolean isElementInvisible(String xpath) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			return true;
			
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * getClickableWebElement - get web element clickable in DOM
	 * @param xpath - xpath for webElement
	 * @return webElement
	 */
	public WebElement getClickableWebElement(String xpath) {
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	/**
	 * isElementVisible - wait for visible of web element in DOM and result result if it is visible or not
	 * @param xpath - xpath for webElement
	 * @return true if web element is visibles 
	 */
	public boolean isElementVisible(String xpath) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			return true;
			
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * handleAlert - accpet alert in browser
	 */
	public void handleAlert() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
		}
		catch (Exception e) {
			return;
		}
		this.driver.switchTo().alert().accept();
	}
}
