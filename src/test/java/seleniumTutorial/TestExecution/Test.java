package seleniumTutorial.TestExecution;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("dev@dev.com");
		driver.findElement(By.id("userPassword")).sendKeys("Test@12345");
		driver.findElement(By.id("login")).click();
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> elements  =  driver.findElements(By.cssSelector(".mb-3"));
		
		
		WebElement prod = elements.stream()
				.filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);
				
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		prod.findElement(By.xpath("//button[text()=' Add To Cart']")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));                   // performance issue{ load delay }
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		
//		-----------------------------------
		
		
		
		List<WebElement> cartList =  driver.findElements(By.cssSelector(".cartSection h3"));    //done
		
		Boolean value = cartList.stream().anyMatch(x->x.getText().equalsIgnoreCase("ZARA COAT 3"));  //done
		
		Assert.assertTrue(value);   //done
		 
		driver.findElement(By.xpath("//*[text()='Checkout']")).click();   //done
		
		
		
//		------------------------------------------
		
		driver.findElement(By.cssSelector(".form-group input")).sendKeys("Ind"); //done
		
		List<WebElement> lst = driver.findElements(By.cssSelector(".ta-item"));   //done
		
		lst.stream().filter(x->x.getText().equalsIgnoreCase("India")).findFirst().orElse(null).click(); //done
		
		
		driver.findElement(By.cssSelector(".actions a")).click(); //done
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))); //done
		
		String text = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(text.equalsIgnoreCase(" Thankyou for the order. "));
		
		
//		Actions  a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']"))).build().perform();

	}

}
