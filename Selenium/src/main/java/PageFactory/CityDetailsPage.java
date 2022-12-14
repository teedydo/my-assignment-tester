package PageFactory;

import org.openqa.selenium.WebDriver;

import LocatorConstant.CityDetailsPageConstant;
import utilities.AbstractTest;
import utilities.WebDriverCustom;

public class CityDetailsPage extends AbstractTest{
	private WebDriverCustom driverCustom;
	public String DATE_FORMAT_IN_DETAILS_PAGE = "MMM dd";
	
	public CityDetailsPage (WebDriver driver) {
		this.driver = driver;
		this.driverCustom = new WebDriverCustom(driver);
	}
	
	/**
	 * Wait for City details page loaded completely 
	 */
	public void waitForPageLoadedCompleted() {
		do {
			this.driverCustom.isElementInvisible("//div[@aria-label='Loading']");
			waitForSecs(2);
		}
		while (this.driverCustom.isElementVisible("//div[@aria-label='Loading']"));
		this.driverCustom.isElementVisible("//div[@class='map-section']");
	}
	
	/**
	 * isCityNameDisplayed - From City details page, verify if expected city name displayed
	 * @param cityName - Name of city
	 * @return true - if name of city displayed as expected
	 */
	public boolean isCityNameDisplayed(String cityName) {
		return this.driverCustom.isElementVisible(String.format(CityDetailsPageConstant.lblCityName, "cityName"));
	}
	
	/**
	 * getCurrentDateDisplayed - From City details page, get current date displayed
	 * @return currentDate - current date displayed
	 */
	public String getCurrentDateDisplayed() {
		return this.driverCustom.getVisibleWebElement(CityDetailsPageConstant.lblCurrentDate).getText();
	}
	
	/**
	 * getCurrentTemperature - From City details page, get current temperature displayed
	 * @return currentTemperature - current temperature displayed
	 */
	public String getCurrentTemperature() {
		return this.driverCustom.getVisibleWebElement(CityDetailsPageConstant.lblCurrentTemp).getText();
	}
	
	/**
	 * verifyTextDisplayWithSelectedMeasurement - From City details page, verify if temperature displayed with correct format
	 * @param text - input text to verify
	 * @param isDisplayedInC - true if expected text displayed in C format, false if expected text displayed in F format
	 * @return true if text displayed in correct format
	 */
	public boolean verifyTextDisplayWithSelectedMeasurement(String text, boolean isDisplayedInC) {
		if (isDisplayedInC) {
			return text.matches("\\d+?c(?:\\s*-\\d+?c)?");
		}
		else {
			return text.matches("\\d+?F(?:\\s*-\\d+?F)?");
		}
	}
	
	/**
	 * selectCTemperatureMeasurements - From City details page, select measurements for temperature
	 * @param isDisplayedInC - true if expected text displayed in C format, false if expected text displayed in F format
	 */
	public void selectCTemperatureMeasurements(boolean isDisplayedInC) {
		if (isDisplayedInC) {
			this.driverCustom.getClickableWebElement(CityDetailsPageConstant.optCMessure).click();
		}
		else {
			this.driverCustom.getClickableWebElement(CityDetailsPageConstant.optFMessure).click();
		}
		this.driverCustom.isElementVisible(CityDetailsPageConstant.optLoaded);
	}
}
