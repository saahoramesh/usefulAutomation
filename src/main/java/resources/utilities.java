package resources;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import AutomationProject.academy.Loginpage;
import junit.framework.Assert;

public class utilities extends base{
	WebDriver driver;
	public WebDriver validatetextOfHeadingInLandingPage(Loginpage login) throws IOException {  
		
		driver=initializeDriver("chrome");
		String url = prop.getProperty("url");
		driver.get(url);
		
		login.getName().sendKeys("ramesh angoth");;
		login.getEmail().sendKeys("raslice8@gmail.com");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", login.getSubmit());
		
     return driver;
}
}
