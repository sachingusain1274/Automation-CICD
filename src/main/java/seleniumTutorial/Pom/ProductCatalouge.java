package seleniumTutorial.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumTutorial.AbstractComponent.AbstractComponent;

public class ProductCatalouge extends AbstractComponent  {
	
	WebDriver driver;
	
	public ProductCatalouge(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")																			//new way
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	
	

	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("//button[text()=' Add To Cart']");
	By tost = By.id("toast-container");
	
	
	public  	List<WebElement> getProductList()
	{
		waitForVisibilityOfElement(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		return getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public CartPage addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForVisibilityOfElement(tost);
		waitForInvisibilityOfElement(spinner);
		cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
		
	}
	

	
	
	
	


}
