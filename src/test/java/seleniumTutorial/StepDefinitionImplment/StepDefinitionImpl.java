package seleniumTutorial.StepDefinitionImplment;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumTutorial.Pom.CartPage;
import seleniumTutorial.Pom.LoginPage;
import seleniumTutorial.Pom.ProductCatalouge;
import seleniumTutorial.TestComponent.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	
//	tidy gerkin chrome plugin to genereate stepdefinition code
	
	public LoginPage loginPage;
	public ProductCatalouge productCatalouge;
	public CartPage cartPage;
	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_Ecommerce_Page() throws IOException{
		
		loginPage= launchApplication();
	}
	
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void loggedIn(String username , String password) {
		
		ProductCatalouge productCatalouge =  loginPage.loginApp(username,password);
		
	}
	
	@When("^I add product (.+) from Cart$")
	public void i_add_product_to_cart(String productName) {
		
		CartPage cartPage =  productCatalouge.addProductToCart(productName);
		
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		
	}
	
	@Then("^\"([^\"]*)\" message is displayed on ConfirmPage$")
	public void confirm(String msg)
	{
//		Assert.assertEquals(msg, "Incorrect email or password.");
//		driver.close();
	}
	
	
	
	@Then("^\"([^\"]*)\"	 message is displayed$")
	public void errorDisplayed(String msg)
	{
		Assert.assertEquals(msg, "Incorrect email or password.");
		driver.close();
	}



	
	
	
	

}
