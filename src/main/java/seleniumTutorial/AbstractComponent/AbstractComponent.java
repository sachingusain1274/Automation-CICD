package seleniumTutorial.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver) {

		this.driver = driver;
	}
	
	
	public void waitForVisibilityOfElement(By by) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	
	}
	
	public void waitForWebElelment(WebElement by) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(by));
	
	}
	
	public void waitForInvisibilityOfElement(WebElement element) 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
		}
	
	

}
