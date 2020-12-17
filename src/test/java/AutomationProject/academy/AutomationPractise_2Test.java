package AutomationProject.academy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import resources.base;

public class AutomationPractise_2Test extends base {
	WebDriver driver;
	AutomationPractice_2 autoP;
	int index = 1;

	@Test
	public void navigateToAtomationPractise2Page() throws IOException {

		driver = initializeDriver("chrome");
		autoP = new AutomationPractice_2(driver);
		authenticateTheURL(new Loginpage(driver));
		autoP.getAutomationPractise().click();
	}

	@Test
	public void validateRadioButton() {

		List<WebElement> buttons = autoP.getRadioButtons();

		for (int i = 0; i < buttons.size(); i++) {
			if (i == index) {
				buttons.get(i).click();
				break;
			}
		}
	}

	@Test
	public void validateCheckBox() {

		List<WebElement> chck = autoP.getCheckboxes();
		for (int i = 0; i < chck.size(); i++) {
			if (i == index) {
				chck.get(i).click();
				break;
			}
		}
	}
	@Test
	public void validateSimpleDropDown() {
		
      Select sl=new Select(autoP.getDropDownSelect());
      sl.selectByIndex(index);
      
	}
	@Test
	public void validateAutoSuggest() {
		 
     autoP.getAutoComplete().sendKeys("ind");
     JavascriptExecutor js=(JavascriptExecutor)driver;
     String country=(String) js.executeScript("return arguments[0].value", autoP.getAutoComplete());
System.out.println(country);
     //String script = "return   document.getElementByXPath(autoP.getAutoComplete()).getText();";
     //String telno1 = js.executeScript(script).toString();
     
	}

}
