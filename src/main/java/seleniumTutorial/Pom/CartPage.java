package seleniumTutorial.Pom;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage{
	
WebDriver driver;
	
	public CartPage(WebDriver driver) {
		

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(xpath = "//*[text()='Checkout']")
	WebElement checkoutBtn;
	
	public List<WebElement> getCartList(){
		return cartList;
	}
	
	public boolean productMatch(String productName) {
		boolean status = getCartList().stream().anyMatch(x->x.getText().equalsIgnoreCase(productName));
		return status;
		
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutBtn.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	
	

}
