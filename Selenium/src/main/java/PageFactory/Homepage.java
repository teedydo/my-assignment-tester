package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LocatorConstant.HomePageConstant;
import utilities.AbstractTest;
import utilities.WebDriverCustom;

public class Homepage extends AbstractTest{
	private WebDriver driver;
	private WebDriverCustom driverCustom;
	public Homepage (WebDriver driver) {
		this.driver = driver;
		this.driverCustom = new WebDriverCustom(driver);
	}
	
	/**
	 * Wait for Home page loaded completely 
	 */
	public void waitForPageLoadedCompleted() {
		do {
			this.driverCustom.isElementInvisible(HomePageConstant.dlgLoading);
			waitForSecs(2);
		}
		while (this.driverCustom.isElementVisible(HomePageConstant.dlgLoading));
	}
	
	/**
	 * From search city text box, input city name and click on Search button
	 * @param cityName - Name of city
	 */
	public void searchCity (String cityName) {
		WebElement txbSearch = this.driverCustom.getClickableWebElement(HomePageConstant.txbSearch);
		txbSearch.click();
		txbSearch.clear();
		txbSearch.sendKeys(cityName);
		WebElement btnSearch = this.driverCustom.getClickableWebElement(HomePageConstant.btnSearch);
		btnSearch.click();
	}
	
	/**
	 * From search result, selected search result 
	 * @param searchText - Searched text in search result
	 */
	public void selectResult (String searchText) {
		WebElement searchResult = this.driverCustom.getClickableWebElement(String.format(HomePageConstant.optSearchResult, searchText));
		searchResult.click();
	}
}
