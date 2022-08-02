package PageFactory;

import org.openqa.selenium.WebDriver;

public class MyPageFactory {
	public CityDetailsPage cityDetailsPage;
	public Homepage homepage;
	public WebDriver driver;
	
	public MyPageFactory (WebDriver driver) {
		this.driver = driver;
	}
	
	public CityDetailsPage getCityDetailsPage() {
		return new CityDetailsPage(driver);
	}
	
	public Homepage getHomepage() {
		return new Homepage(driver);
	}
}
