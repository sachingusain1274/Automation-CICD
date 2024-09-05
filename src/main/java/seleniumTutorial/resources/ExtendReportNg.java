package seleniumTutorial.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportNg {
	
	
	public static ExtentReports getTestReport()
	{
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//+index.html");
		extentSparkReporter.config().setDocumentTitle("Test Report");
		extentSparkReporter.config().setReportName("Web Testing");
		
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Anonyemus");
		
		return extentReports;
		
		
		
	}
	
	

}
