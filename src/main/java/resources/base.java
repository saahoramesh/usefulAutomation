package resources;
	import java.awt.Dimension;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import AutomationProject.academy.Loginpage;

	public class base {
		public static WebDriver driver;
		public static String dir = System.getProperty("user.dir");
		public static Properties prop;

		public static WebDriver initializeDriver(String browser) throws IOException {

			String file = "" + dir + "\\src\\main\\java\\resources\\GlobalVariables.properties";
			 prop = new Properties();

			FileInputStream fis = new FileInputStream(file);

			prop.load(fis);
			String browserName = prop.getProperty("browser");

			if (browserName.equalsIgnoreCase(browser)) {
				System.setProperty("webdriver.chrome.driver", "" + dir + "\\webdrivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver", "" + dir + "\\webdrivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			} else if (browserName.equalsIgnoreCase("FireFox")) {

				System.setProperty("webdriver.gecko.driver", "" + dir + "\\webdrivers\\geckodriver.exe");
				driver = new FirefoxDriver();

			}
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			return driver;

		}

		
		public WebDriver authenticateTheURL(Loginpage login) throws IOException {  
			
			//driver=initializeDriver("chrome");
			String url = prop.getProperty("url");
			driver.get(url);
			
			login.getName().sendKeys("ramesh angoth");;
			login.getEmail().sendKeys("raslice8@gmail.com");
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", login.getSubmit());
			
	     return driver;
	}
		
		
			
		}

	


