package seleniumTutorial.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumTutorial.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
		WebDriver driver;
	
		public CheckoutPage(WebDriver driver) 
		{
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(css = ".form-group input")
		WebElement Country;
		
		@FindBy(css = ".ta-item")
		List<WebElement> countryList;
		
		@FindBy(css = ".hero-primary")
		WebElement successText;
		
		@FindBy(css = ".action__submit ")
		WebElement submit;
		
		By toastBy = By.id("toast-container");
		
		
		public void selectCountry(String country) {
			Country.sendKeys(country);
		}
		
		
		public void checkCountryName(String countryName) throws InterruptedException
		{
			
			Thread.sleep(2000);
//			for(WebElement country :countryList) {
//			
//				 
//				 if(country.getText().equalsIgnoreCase("India")) { 
//				  			country.click();
//				  			break;
//				 }
//			}
			
			countryList.stream().filter(x->x.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null).click();

			Thread.sleep(2000);
					
			submit.click();
			waitForVisibilityOfElement(toastBy);
			
		}
		
		public String checkFinalStatus()
		{
			String text = successText.getText();
			return text;
			
		}
			




}
