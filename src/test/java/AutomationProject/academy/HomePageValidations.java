package AutomationProject.academy;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.base;
import resources.utilities;

public class HomePageValidations extends base {
	WebDriver driver;
	Loginpage logn;
	utilities util;
	AutomationPractice_2 ap;
	int index=2;
	
/*@BeforeClass
	public void initialize() throws IOException {	
		
		driver=initializeDriver("chrome");
		String url = prop.getProperty("url");
		driver.get(url);
	}*/
        
	
	@Test
	public void ValidateRadioButtons() throws IOException{
		authenticateTheURL(new Loginpage(driver));
		//util=new utilities();
		driver=util.validatetextOfHeadingInLandingPage(new Loginpage(driver));
		 ap=new AutomationPractice_2(driver);
		List<WebElement> buttons=ap.getRadioButtons();
		for(int i=0;i<buttons.size();i++)
		{
			if(i==index){
				buttons.get(i).click();
				break;
			}
		}
	}
	
	
	public void validateCheckBox() {
		//util=new utilities();
		//util.validatetextOfHeadingInLandingPage(new Loginpage(driver));
		ap=new AutomationPractice_2(driver);
		List<WebElement> chck=ap.getCheckboxes();
		for(int i=0;i<chck.size();i++)
		{
			if(i==index){
				chck.get(i).click();
				break;
			}
		}
	}
	

}
