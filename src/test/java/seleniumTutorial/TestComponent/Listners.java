package seleniumTutorial.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumTutorial.resources.ExtendReportNg;

public class Listners extends BaseTest implements ITestListener{
	

	ExtentTest test;
	ExtentReports extent =   ExtendReportNg.getTestReport();
	
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();   //thread safe
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		threadLocal.set(test);     //unique thread id 
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		threadLocal.get().log(Status.PASS, "Test Pass");
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		threadLocal.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = null;
		try {
			 path = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		threadLocal.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		threadLocal.get().log(Status.FAIL, "Test Fail");

	}
	
	
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

}
