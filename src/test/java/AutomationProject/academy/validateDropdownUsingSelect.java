package AutomationProject.academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import resources.base;
import resources.utilities;

public class validateDropdownUsingSelect extends base{
	
	WebDriver driver;
@Test	
public void dropDowns() throws IOException {
	
	driver=initializeDriver("chrome");
	String url = prop.getProperty("url");
	driver.get(url);
	
	//utilities util=new utilities();
	//util.validatetextOfHeadingInLandingPage(new Loginpage(driver));
	AutomationPractice drop=new AutomationPractice(driver);
	drop.getRadioButtons();
	Select sl=new Select(drop.getDropDownSelect());
	sl.selectByIndex(2);
}
  

}
