package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigurationData {
	// Webpage URL
	public static String URL = "";
	
	// Place to stored your screenshot
	public static String SCREENSHOT_PATH = "";
	
	public static void loadProperties() {
		String projectPropertiesFileName = "project.properties";
		FileReader reader = null;
		try {
			Properties prop = new Properties();
			reader = new FileReader(projectPropertiesFileName);
			BufferedReader br = new BufferedReader(reader);
			prop.load(br);
			URL = prop.getProperty("url");
			SCREENSHOT_PATH = prop.getProperty("screenshotPath");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
