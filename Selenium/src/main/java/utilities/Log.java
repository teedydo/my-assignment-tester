package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	public static void loadLogConfiguration() {
		String logProperties = MyFileUtils.getUserPath() + "log4j.properties";
		PropertyConfigurator.configure(logProperties);
	}
	
	public static void startTestClass(String testClass) {
		Log.info("===========================================================");
		Log.info("**************** EXECUTE CLASS: " + testClass);
		Log.info("===========================================================");
	}
	
	public static void startTestCase (String testCaseName) {
		Log.info("**************** START TEST: " + testCaseName);
	}
	
	public static void endTestCase (String testCaseName) {
		Log.info("**************** END TEST: " + testCaseName);
	}
	
	public static void endTests(String testClass) {
		Log.info("===========================================================");
		Log.info("**************** END EXECUTION");
		Log.info("===========================================================");
	}
	
	public static void warn(String msg) {
		Log.warn(msg);
	}
	
	public static void error(String msg) {
		Log.error(msg);
	}
	
	public static void fatal(String msg) {
		Log.fatal(msg);
	}
	
	public static void debug(String msg) {
		Log.debug(msg);
	}
}
