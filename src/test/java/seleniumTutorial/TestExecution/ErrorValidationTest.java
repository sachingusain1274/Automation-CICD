package seleniumTutorial.TestExecution;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumTutorial.TestComponent.BaseTest;
import seleniumTutorial.TestComponent.RerunFailedTest;

public class ErrorValidationTest extends BaseTest{
	
	@Test(retryAnalyzer = RerunFailedTest.class)       //(retryAnalyzer = RerunFailedTest.class)   for Re- run the failed test again
	public void loginErrorValidation()
	{
		loginPage.loginApp("dev@dev.com", "Test@12345");
		Assert.assertEquals("Incorrect email  password.", "Incorrect email or password.");
	}

}
