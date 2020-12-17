package AutomationProject.academy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class AutomationPractice extends base{
	WebDriver driver;

	public AutomationPractice(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//div[@id='radio-btn-example']/fieldset/label/input")
		List<WebElement> radioButtons;	
		
		@FindBy(xpath="//*[@id='dropdown-class-example']")
		WebElement dropDownSelect;
		
		@FindBy(xpath="//*[@id='checkbox-example']/fieldset/label/input")
		List<WebElement> checkboxes;
		
		public List<WebElement> getCheckboxes() {
			return checkboxes;
		}
		public WebElement getDropDownSelect() {
			return dropDownSelect;
		}
		public List<WebElement> getRadioButtons() {
			return radioButtons;
		}
		
	}




