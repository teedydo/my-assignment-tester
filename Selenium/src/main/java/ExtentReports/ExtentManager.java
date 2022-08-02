package ExtentReports;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

import utilities.MyDateUtils;
import utilities.MyFileUtils;

public class ExtentManager {
	private static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			String workingPath = MyFileUtils.getUserPath() + "test-output"
					+ File.separator + "report" + File.separator + "extentReports";
			File dir = new File(workingPath);
			if (!dir.exists()) {
				dir.mkdir();
			}
			String extentReportFile = dir.getAbsolutePath() + File.separator + "ExtentReportResults_" + MyDateUtils.getCurrentTimeString() + ".html";
			System.out.println(extentReportFile);
			extent = new ExtentReports(extentReportFile, true);
			File configLocation = new File(MyFileUtils.getUserPath() + "extent-config.xml");
			extent.loadConfig(configLocation);
		}
		return extent;
	}
}
