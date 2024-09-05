package seleniumTutorial.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumTutorial.AbstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement email1 = driver.findElement(By.id("userEmail"));     //old way
	//PageFactory
	@FindBy(id = "userEmail")																			//new way
	WebElement email;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement loginBtn;
	
	@FindBy(css = "class*='flyInOut']")
	WebElement errorMessage;
	
	//Implenting actions
	
	public void url() {
		driver.get("https://rahulshettyacademy.com/client");
//		driver.get(Cons/tants.url);
	}
	
	public ProductCatalouge loginApp(String e,String p) {
		
		email.sendKeys(e);
		password.sendKeys(p);
		loginBtn.click();
		ProductCatalouge productCatalouge = new ProductCatalouge(driver);
		return productCatalouge;
		
	}
	
	public String errorMsg()
	{
		waitForWebElelment(errorMessage );
		return errorMessage.getText();
	}
	
	
	

	
	
	
	


}
