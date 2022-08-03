# my assignment tester
How to execute Framework? <br>
---How to import project into Esclipe <br>
Step 1: Open blank Workspace in Esclipe <br>
Step 2: Select option "Checkout project from GIT" <br>
Step 3: Select option "Clone URI" from step Select Repository Source <br>
Step 4: Paste URI with this GIT project <br>
Step 5: Branch selection: Click on Next <br>
Step 6: Local Destination: Select your folder and click on Next <br>
Step 7: Wait for clone project <br>
Step 8: Accept default value  <br>

---How to execute TestNG test suite <br>
Run /Selenium/src/main/java/utilities/runner/testng.xml with TestNG <br>

--- How to change Execution Browser
In /Selenium/src/main/java/utilities/AbstractTest.java <br> 
At utilities.AbstractTest.setUp(ITestContext) method <br>
Change to: <br>
Chrome: <br>
		this.webDriverType = WebDriverType.CHROME; <br>
Firefox: <br>
		this.webDriverType = WebDriverType.FIREFOX; <br>
Install Chrome version 103 and Firefox version 103 before execution <br>

--- Get report from Extend report after execution <br>
Location: /Selenium/test-output/report/extentReports <br>
