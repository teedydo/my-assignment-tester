package LocatorConstant;

public class CityDetailsPageConstant {
	// Xpath for label of City name
	public static String lblCityName = "//div[@data-v-3e6e9f12]//h2[contains(text(),%s)]";
	
	// Xpath for label of Current date 
	public static String lblCurrentDate = "//div[@data-v-3e6e9f12]//span[@class='orange-text']";
	
	// Xpath for label for Current temperature
	public static String lblCurrentTemp = "//div[@class='current-temp']//span";
	
	// Xpath for Option: Display by C - Metric
	public static String optCMessure = "//div[@class='switch-container']//div[@class='option' and contains(text(),'Metric')]";
	
	// Xpath for Option: Display by F - Imperial
	public static String optFMessure = "//div[@class='switch-container']//div[@class='option' and contains(text(),'Imperial')]";
	
	// Xpath for waiting Option: Displayed by measurement loaded
	public static String optLoaded = "//div[@class='switch-container']//div[@class='']";
}
