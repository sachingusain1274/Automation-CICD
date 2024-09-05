package seleniumTutorial.TestExecution;

import java.io.IOException;


import org.testng.Assert;

import seleniumTutorial.Pom.CartPage;
import seleniumTutorial.Pom.CheckoutPage;
import seleniumTutorial.Pom.LoginPage;
import seleniumTutorial.Pom.ProductCatalouge;
import seleniumTutorial.TestComponent.BaseTest;

public class TestExecution3 extends BaseTest{
	
	@org.testng.annotations.Test
	public void test() throws InterruptedException, IOException
	{
	
	String email = "dev@dev.com";
	String password = "Test@12345";
	String productName = "ZARA COAT 3";
	String countryName1 = "ind";
	String countryName2 = "India";
	String status = "Thankyou for the order.";

	
	ProductCatalouge productCatalouge =  loginPage.loginApp(email, password);
	
	 CartPage cartPage =  productCatalouge.addProductToCart(productName);
	 
	boolean value =  cartPage.productMatch(productName);
	Assert.assertTrue(value);
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry(countryName1);
	checkoutPage.checkCountryName(countryName2);
	String result  = checkoutPage.checkFinalStatus();
	Assert.assertTrue(result.equalsIgnoreCase(status));
	System.out.println("test completd");
//	driver.close();
	 
	
	//button[contatin(@class,'submit')]
	
	
	
	}

	
	
	

}
