package LocatorConstant;

public class HomePageConstant {

	// Xpath for loading dialog
	public static String dlgLoading = "//div[@aria-label='Loading']";
	
	// Xpath for textbox search city
	public static String txbSearch = "//div[@class='search-container']//input";
	
	// Xpath for button Search
	public static String btnSearch = "//button[text()='Search']";
	
	// Xpath for searched option in search result
	public static String optSearchResult = "//ul[@class='search-dropdown-menu']//span[contains(text(),'%s')]";
}
