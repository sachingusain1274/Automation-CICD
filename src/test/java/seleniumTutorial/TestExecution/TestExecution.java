package seleniumTutorial.TestExecution;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import seleniumTutorial.Pom.CartPage;
import seleniumTutorial.Pom.CheckoutPage;
import seleniumTutorial.Pom.LoginPage;
import seleniumTutorial.Pom.ProductCatalouge;
import seleniumTutorial.TestComponent.BaseTest;
import org.testng.annotations.Test;

public class TestExecution extends BaseTest{
	
	// new comment added for cicd purpose
	
	@Test(dataProvider = "getData" , groups = "purchase")
	public void test(HashMap<String, String> data) throws InterruptedException, IOException
	{
	
	String email = "dev@dev.com";
	String password = "Test@12345";
	String productName = "ZARA COAT 3";
	String countryName1 = "ind";
	String countryName2 = "India";
	String status = "Thankyou for the order.";

	
	ProductCatalouge productCatalouge =  loginPage.loginApp(data.get("email"), data.get("pass"));
	
	 CartPage cartPage =  productCatalouge.addProductToCart(data.get("product"));
	 
	boolean value =  cartPage.productMatch(data.get("product"));
	Assert.assertTrue(value);
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry(countryName1);
	checkoutPage.checkCountryName(countryName2);
	String result  = checkoutPage.checkFinalStatus();
	Assert.assertTrue(result.equalsIgnoreCase(status));
	System.out.println("test completd");
	
	
	}
	
	
	
	
	
//	@org.testng.annotations.Test
//	public void test() throws InterruptedException, IOException
//	{
//	
//	String email = "dev@dev.com";
//	String password = "Test@12345";
//	String productName = "ZARA COAT 3";
//	String countryName1 = "ind";
//	String countryName2 = "India";
//	String status = "Thankyou for the order.";
//
//	
//	ProductCatalouge productCatalouge =  loginPage.loginApp(email, password);
//	
//	 CartPage cartPage =  productCatalouge.addProductToCart(productName);
//	 
//	boolean value =  cartPage.productMatch(productName);
//	Assert.assertTrue(value);
//	CheckoutPage checkoutPage = cartPage.goToCheckout();
//	checkoutPage.selectCountry(countryName1);
//	checkoutPage.checkCountryName(countryName2);
//	String result  = checkoutPage.checkFinalStatus();
//	Assert.assertTrue(result.equalsIgnoreCase(status));
//	System.out.println("test completd");
//	}
	
	
	
//	@Test(dataProvider = "getData" , groups = "purchase")
//	public void test(String u , String p , String i) throws InterruptedException, IOException
//	{
//	
//	String email = "dev@dev.com";
//	String password = "Test@12345";
//	String productName = "ZARA COAT 3";
//	String countryName1 = "ind";
//	String countryName2 = "India";
//	String status = "Thankyou for the order.";
//
//	
//	ProductCatalouge productCatalouge =  loginPage.loginApp(u, p);
//	
//	 CartPage cartPage =  productCatalouge.addProductToCart(p);
//	 
//	boolean value =  cartPage.productMatch(i);
//	Assert.assertTrue(value);
//	CheckoutPage checkoutPage = cartPage.goToCheckout();
//	checkoutPage.selectCountry(countryName1);
//	checkoutPage.checkCountryName(countryName2);
//	String result  = checkoutPage.checkFinalStatus();
//	Assert.assertTrue(result.equalsIgnoreCase(status));
//	System.out.println("test completd");
//	}
	
//	@DataProvider  						//provides data sets to the test so that it will run with more then with different data
//	public Object[][] getData()
//	{
////	instead of array we can use hashmap so that it can ease our workload
//		
//		return new Object[][] {{"dev@dev.com","Test@12345","ZARA COAT 3"} , {"dev@dev.com","Test@12345","ZARA COAT 3"} };
//		
//	}
	
	@DataProvider  						//provides data sets to the test so that it will run with more then with different data
	public Object[][] getData() throws IOException
	{		
//		HashMap<String, String> map = new HashMap<>();
//		map.put("e", "dev@dev.com");
//		map.put("u", "Test@12345");
//		map.put("p", "ZARA COAT 3");
//		
		List<HashMap<String, String>> data =  getJsonData(System.getProperty("user.dir")+"//src//test//java//seleniumTutorial//jsonData//order.json");

//		return new Object[][] {{map} , {map} };
		
		return new Object[][] {{data.get(0)} , {data.get(1)} };
		
	}

	
	
	

}
