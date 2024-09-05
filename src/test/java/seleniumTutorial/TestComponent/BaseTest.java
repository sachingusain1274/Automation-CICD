package seleniumTutorial.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumTutorial.Pom.LoginPage;

public class BaseTest {
	
	 public WebDriver driver;
	 public LoginPage loginPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/seleniumTutorial/resources/GlobalData.properties");
		properties.load(fi);
		
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : properties.getProperty("browser");
		
//		String browser = properties.getProperty("browser", null);
		
		//chrome
		if(browser.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();     //Through this option we can restrict chrome browser to open but it can do testing in background withou open chrome.
			WebDriverManager.chromedriver().setup();
			if(browser.contains("headless"))     //without open chrome , continuing testing
			{
			options.addArguments("headless");
			}
			 driver = new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1440, 900));
		}
		
//		firefox	
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().fullscreen();
		return driver;
		
	}

	
	@BeforeMethod(alwaysRun = true)        																											//call before exceution class
		public LoginPage launchApplication() throws IOException {
			driver = initializeDriver();
		
			loginPage = new LoginPage(driver);
			loginPage.url();
			return loginPage;
		}
	
	@AfterMethod(alwaysRun = true)
	public void finishTest()
	{
		driver.close();
	}
	
	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> getJsonData(String path) throws IOException
	{
//		read json to string
		String json = FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
		
		
//		Jackson DataBind ->convert json to String
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> data =  objectMapper.readValue(json,new TypeReference<List<HashMap<String,String>>>() {
		});
	
		return data;
	
	
	}
	
//	Take a screen shot when test case is failed
	
	public String getScreenShot(String testCaseName ,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;	
		File file = ts.getScreenshotAs(OutputType.FILE);
		File file2 = new File(System.getProperty("user.dir")+"//reports//" +testCaseName +".png");
		FileUtils.copyFile(file, file2);
		return System.getProperty("user.dir")+"//reports//" +testCaseName +".png";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
