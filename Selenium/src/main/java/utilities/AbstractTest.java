package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import utilities.WebDriverBuilder.WebDriverType;

public class AbstractTest {

	public WebDriverType webDriverType;
	public WebDriver driver;
	public WebDriverCustom driverCustom;
	protected static String URL;
	protected static String SCREENSHOT_PATH;
	protected String methodName;
	
	@BeforeMethod
	public void getMethodName(ITestContext context, Method method)
	{
		this.methodName = context.getName();
	}

	@BeforeClass
	public void setUp(ITestContext context) {
		this.webDriverType = WebDriverType.CHROME;
		this.driver = WebDriverBuilder.createWebDriver(webDriverType);
		this.driverCustom = new WebDriverCustom(driver);
		context.setAttribute("webDriver", driver);
		URL = ConfigurationData.URL;
		SCREENSHOT_PATH = ConfigurationData.SCREENSHOT_PATH;
		this.driver.navigate().to(URL);
		driver.manage().window().maximize();
		this.driverCustom.isElementInvisible("//div[@aria-label='Loading']");
	}

	@AfterClass
	public void tearDown() {
		this.driver.quit();
	}

	/**
	 * Take screenshot in browser
	 * @param name - File name 
	 * @param driver - current webDriver
	 * @return screenshot file
	 */
	public File takeScreenshot(String name, WebDriver driver) {
		String workingPath = MyFileUtils.getUserPath() + SCREENSHOT_PATH;
		File dir = new File(workingPath);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageFileDir = System.getProperty("selenium.screenshot.dir");
		if (imageFileDir == null) {
			imageFileDir = System.getProperty("java.io.tmpdir");
		}
		try {
			FileUtils.copyFile(screenshotFile, new File(workingPath, name + ".jpg"));
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFile;
	}

	/**
	 * Verify is current session is Null
	 * @return true if Current session is null
	 */
	public boolean isSessionIDNull() {
		SessionId s = ((RemoteWebDriver) driver).getSessionId();
		if (s==null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Wait for some seconds before next action
	 * @param seconds - time in seconds
	 */
	public void waitForSecs(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
