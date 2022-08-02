package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtils {
	private MyDateUtils() {
		// do nothing
	}
	
	/**
	 * getCurrentDateWithFormat - get string of current date using format
	 * @param format - date format
	 * @return current date in format
	 */
	public static String getCurrentDateWithFormat(String format) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	/**
	 * getCurrentTimeString - generate string of current datetime
	 * @return string of current datetime
	 */
	public static String getCurrentTimeString() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		return dateFormat.format(date);
	}

}
