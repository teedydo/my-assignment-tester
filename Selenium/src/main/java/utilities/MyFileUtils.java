package utilities;

import java.io.File;

public class MyFileUtils {
	
	private MyFileUtils() {
		// do nothing
	}
	
	public static String getUserPath() {
		return System.getProperty("user.dir") + File.separator;
	}
}
